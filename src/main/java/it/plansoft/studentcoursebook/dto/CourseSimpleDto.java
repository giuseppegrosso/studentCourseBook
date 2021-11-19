package it.plansoft.studentcoursebook.dto;

import it.plansoft.studentcoursebook.model.BaseId;
import it.plansoft.studentcoursebook.model.Enrolment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
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
public class CourseSimpleDto extends BaseId<Long> {

    private Long id;
    private String name;
    private String department;

    private LocalDateTime createdAt;
}
