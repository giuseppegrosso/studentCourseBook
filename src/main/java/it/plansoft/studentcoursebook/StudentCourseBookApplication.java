package it.plansoft.studentcoursebook;

import com.github.javafaker.Faker;
import it.plansoft.studentcoursebook.model.*;
import it.plansoft.studentcoursebook.repository.StudentIdCardRepository;
import it.plansoft.studentcoursebook.repository.StudentRepository;
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
			StudentIdCardRepository studentIdCardRepository) {
		return args -> {
			Faker faker = new Faker();

			String firstName = faker.name().firstName();
			String lastName = faker.name().lastName();
			String email = String.format("%s.%s.@gmail.com", firstName.toLowerCase(), lastName.toLowerCase());
			Student student = new Student(
					firstName,
					lastName,
					email,
					faker.number().numberBetween(17, 55));

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

			student.addEnrolment(new Enrolment(
					new EnrolmentId(1L, 1L),
					student,
					new Course("Spring boot", "IT"),
					LocalDateTime.now()
			));

			student.addEnrolment(new Enrolment(
					new EnrolmentId(1L, 2L),
					student,
					new Course("Spring Data JPA", "IT"),
					LocalDateTime.now().minusDays(18)
			));

			student.addEnrolment(new Enrolment(
					new EnrolmentId(1L, 2L),
					student,
					new Course("Spring Data JPA", "IT"),
					LocalDateTime.now().minusDays(18)
			));



			studentRepository.save(student);

			studentRepository.findById(1L)
					.ifPresent(s -> {
						System.out.println("fetch book lazy...");
						List<Book> books = student.getBooks();
						books.forEach(book -> {
							System.out.println(
									s.getFirstName() + " borrowed " + book.getBookName());
						});
					});

		};
	}

}
