package it.plansoft.studentcoursebook;

import com.github.javafaker.Faker;
import it.plansoft.studentcoursebook.dto.CourseDto;
import it.plansoft.studentcoursebook.dto.EnrolmentDto;
import it.plansoft.studentcoursebook.dto.StudentDto;
import it.plansoft.studentcoursebook.mapper.CycleAvoidingMappingContext;
import it.plansoft.studentcoursebook.mapper.IStudentMapper;
import it.plansoft.studentcoursebook.model.*;
import it.plansoft.studentcoursebook.repository.StudentIdCardRepository;
import it.plansoft.studentcoursebook.repository.StudentRepository;
import it.plansoft.studentcoursebook.service.EnrolmentService;
import it.plansoft.studentcoursebook.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class StudentCourseBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentCourseBookApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(
			StudentRepository studentRepository,
			StudentIdCardRepository studentIdCardRepository,
			EnrolmentService enrolmentService,
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

			// 2. istanza corso
			CourseDto course1 = new CourseDto("Spring boot", "IT");

			// 3. associazione iscrizione
//			student.addEnrolment(new Enrolment(
//					new EnrolmentId(1L, 1L),
//					student,
//					course1,
//					LocalDateTime.now()
//			));

//			student.addEnrolment(new Enrolment(
//					new EnrolmentId(1L, 2L),
//					student,
//					new Course("Spring Data JPA", "IT"),
//					LocalDateTime.now().minusDays(18)
//			));
//
//			student.addEnrolment(new Enrolment(
//					new EnrolmentId(1L, 2L),
//					student,
//					new Course("Spring Data JPA", "IT"),
//					LocalDateTime.now().minusDays(18)
//			));



			// 4. salvataggio
//			studentRepository.save(student);
			StudentDto studentDtoSaved = studentService.addStudentCourse(studentDto, course1);

//			System.out.println(studentDtoSaved);

			StudentDto studentDtoRead = studentService.findById(studentDtoSaved.getId());

			System.out.println(studentDtoRead.getFirstName());
			System.out.println(studentDtoRead.getLastName());
			System.out.println(studentDtoRead.getEnrolments());


			// lettura dei dati.
//			studentRepository.findById(1L)
//					.ifPresent(s -> {
//						System.out.println("fetch book lazy...");
//						List<Book> books = student.getBooks();
//						books.forEach(book -> {
//							System.out.println(
//									s.getFirstName() + " borrowed " + book.getBookName());
//						});
//
//						// foreach sui corsi
//						List<Enrolment> courses = student.getEnrolments();
//						courses.forEach(course -> {
//							System.out.println(
//									course.getStudent().getFirstName() + " is enrolled to " + course.getCourse().getName());
//						});
//					});

		};
	}

}
