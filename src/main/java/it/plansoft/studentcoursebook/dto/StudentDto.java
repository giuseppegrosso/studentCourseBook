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

    private StudentIdCard studentIdCard;

    private List<Book> books = new ArrayList<>();

    private List<Enrolment> enrolments = new ArrayList<>();
}
