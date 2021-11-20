package it.plansoft.studentcoursebook.dto;

import it.plansoft.studentcoursebook.model.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

/**
 * @author Giuseppe Grosso
 * @project course
 * @since 16/11/2021
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentDto extends BaseId<Long> {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private String cardNumber;

    private List<BookDto> books = new ArrayList<>();

    // riferimenti al corso e iscrizione al corso.
    private List<CourseDto> courseDtos = new ArrayList<>();

    public StudentDto(Long id, String firstName, String lastName, String email, Integer age, String cardNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.cardNumber = cardNumber;
    }

    public void addCourse(CourseDto courseDto)
    {
        if (courseDtos == null) courseDtos = new ArrayList<>();
        courseDtos.add(courseDto);
    }
}
