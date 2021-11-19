package it.plansoft.studentcoursebook.dto;

import it.plansoft.studentcoursebook.model.BaseId;
import it.plansoft.studentcoursebook.model.Book;
import it.plansoft.studentcoursebook.model.StudentIdCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Giuseppe Grosso
 * @project course
 * @since 16/11/2021
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentSimpleDto extends BaseId<Long> {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private Integer age;

}
