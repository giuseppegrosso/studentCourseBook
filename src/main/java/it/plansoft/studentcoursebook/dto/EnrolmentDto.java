package it.plansoft.studentcoursebook.dto;

import it.plansoft.studentcoursebook.model.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
public class EnrolmentDto {

    private EnrolmentIdDto id;
    private Student student;
    private Course course;

    private LocalDateTime createdAt;
}
