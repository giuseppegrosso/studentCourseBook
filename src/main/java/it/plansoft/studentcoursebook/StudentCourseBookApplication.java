package it.plansoft.studentcoursebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentCourseBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentCourseBookApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(
//            StudentRepository studentRepository,
//            StudentIdCardRepository studentIdCardRepository,
//            StudentService enrolmentService,
//            StudentService studentService) {
//        return args -> {
//
//            Faker faker = new Faker();
//
//            String firstName = faker.name().firstName();
//            String lastName = faker.name().lastName();
//            String email = String.format("%s.%s.@gmail.com", firstName.toLowerCase(), lastName.toLowerCase());
//
//            // 1. istanza studente
//            Student student = new Student(
//                    firstName,
//                    lastName,
//                    email,
//                    faker.number().numberBetween(17, 55));
//
//            StudentDto studentDto = IStudentMapper.INSTANCE.toDto(student, new CycleAvoidingMappingContext());
//
//            student.addBook(
//                    new Book("Flutter", LocalDateTime.now().minusDays(4)));
//
//            student.addBook(
//                    new Book("Spring boot", LocalDateTime.now()));
//
//            student.addBook(
//                    new Book("Spring Data JPA", LocalDateTime.now().minusYears(1)));
//
//            StudentIdCard studentIdCard = new StudentIdCard(
//                    "123456789",
//                    student);
//
//            student.setStudentIdCard(studentIdCard);
//
////            studentDto.addCourse();
////            studentDto.addCourse(new CourseDto("Spring Data JPA", "IT"));
//            // 2. istanza corso
//
//            // 4. salvataggio
//            StudentEnrolmentCourseDto studentDtoSaved = studentService.addEnrolment(studentDto,
//                    Arrays.asList(new CourseEnrolmentDto(new CourseDto("Spring boot", "IT"), LocalDateTime.now())));
//
//            System.out.println(studentDtoSaved.getStudentDto());
//            studentDtoSaved.getCourseEnrolmentDto().forEach(x -> System.out.println(x));
//
//            StudentEnrolmentCourseDto studentDtoRead = null;
//            if (studentDtoSaved != null && studentDtoSaved.getStudentDto() != null && studentDtoSaved.getStudentDto().getId() != null)
//                studentDtoRead = studentService.findByIdStudent(studentDtoSaved.getStudentDto().getId());
//
//            if (studentDtoRead != null && studentDtoRead.getStudentDto().getId() != null) {
//                System.out.println(studentDtoRead.getStudentDto());
//                studentDtoRead.getCourseEnrolmentDto().forEach(x -> System.out.println(x));
//            }
//
//
//        };
//    }

}
