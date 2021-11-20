package it.plansoft.studentcoursebook;

import com.github.javafaker.Faker;
import it.plansoft.studentcoursebook.dto.CourseDto;
import it.plansoft.studentcoursebook.dto.StudentDto;
import it.plansoft.studentcoursebook.mapper.CycleAvoidingMappingContext;
import it.plansoft.studentcoursebook.mapper.IStudentMapper;
import it.plansoft.studentcoursebook.model.Book;
import it.plansoft.studentcoursebook.model.Course;
import it.plansoft.studentcoursebook.model.Student;
import it.plansoft.studentcoursebook.model.StudentIdCard;
import it.plansoft.studentcoursebook.repository.StudentIdCardRepository;
import it.plansoft.studentcoursebook.repository.StudentRepository;
import it.plansoft.studentcoursebook.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

@SpringBootApplication
public class StudentCourseBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentCourseBookApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository studentRepository,
            StudentIdCardRepository studentIdCardRepository,
            StudentService enrolmentService,
            StudentService studentService) {
        return args -> {

            Faker faker = new Faker();

            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s.@gmail.com", firstName.toLowerCase(), lastName.toLowerCase());

            // 1. istanza studente
            Student student = new Student(
                    firstName,
                    lastName,
                    email,
                    faker.number().numberBetween(17, 55));

            StudentDto studentDto = IStudentMapper.INSTANCE.toDto(student, new CycleAvoidingMappingContext());

            student.addBook(
                    new Book("Flutter", LocalDateTime.now().minusDays(4)));

            student.addBook(
                    new Book("Spring boot", LocalDateTime.now()));

            student.addBook(
                    new Book("Spring Data JPA", LocalDateTime.now().minusYears(1)));

            StudentIdCard studentIdCard = new StudentIdCard(
                    "123456789",
                    student);

            student.setStudentIdCard(studentIdCard);

            studentDto.addCourse(new CourseDto("Spring boot", "IT", LocalDateTime.now()));
            studentDto.addCourse(new CourseDto("Spring Data JPA", "IT", LocalDateTime.now()));
            // 2. istanza corso

            // 4. salvataggio
            StudentDto studentDtoSaved = studentService.addEnrolment(studentDto);

            System.out.println(studentDtoSaved.getFirstName());
            System.out.println(studentDtoSaved.getLastName());
            studentDtoSaved.getCourseDtos().forEach(x -> System.out.println(x));

            Optional<StudentDto> studentDtoRead = studentService.findById(studentDtoSaved.getId());

            studentDtoRead.ifPresent(x -> {
                System.out.println(x.getFirstName());
                System.out.println(x.getLastName());
                x.getCourseDtos().forEach(y -> System.out.println(y));
            });

        };
    }

}
