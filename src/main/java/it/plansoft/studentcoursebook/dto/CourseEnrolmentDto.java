package it.plansoft.studentcoursebook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Giuseppe Grosso
 * @project student-course-book
 * @since 20/11/2021
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CourseEnrolmentDto {
    private CourseDto courseDto;
    private LocalDateTime createdAt;
}
