package it.plansoft.studentcoursebook.dto;

import it.plansoft.studentcoursebook.model.BaseId;
import it.plansoft.studentcoursebook.model.Enrolment;
import it.plansoft.studentcoursebook.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
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
public class CourseDto extends BaseId<Long> {

    private Long id;
    private String name;
    private String department;
    private LocalDateTime enrolmentAt;

    public CourseDto(String name, String department, LocalDateTime enrolmentAt) {
        this.name = name;
        this.department = department;
        this.enrolmentAt = enrolmentAt;
    }
}
