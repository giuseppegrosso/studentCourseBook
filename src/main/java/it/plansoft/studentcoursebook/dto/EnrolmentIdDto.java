package it.plansoft.studentcoursebook.dto;

import it.plansoft.studentcoursebook.model.BaseId;
import it.plansoft.studentcoursebook.model.Course;
import it.plansoft.studentcoursebook.model.EnrolmentId;
import it.plansoft.studentcoursebook.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import java.time.LocalDateTime;

/**
 * @author Giuseppe Grosso
 * @project course
 * @since 16/11/2021
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EnrolmentIdDto {

    private Long studentId;
    private Long courseId;
}
