package it.plansoft.studentcoursebook.dto;

import it.plansoft.studentcoursebook.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author Giuseppe Grosso
 * @project course
 * @since 16/11/2021
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentIdCardDto {

    private Long id;

    private String cardNumber;

    private Student student;

}
