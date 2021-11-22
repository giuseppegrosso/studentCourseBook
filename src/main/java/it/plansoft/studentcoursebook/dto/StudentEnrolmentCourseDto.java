package it.plansoft.studentcoursebook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Giuseppe Grosso
 * @project student-course-book
 * @since 21/11/2021
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentEnrolmentCourseDto {

    private StudentDto studentDto;
    private List<CourseEnrolmentDto> courseEnrolmentDto;

    public void addCourse(CourseDto courseDto, LocalDateTime createdAt) {
        if (courseEnrolmentDto == null) courseEnrolmentDto = new ArrayList<>();
        courseEnrolmentDto.add(new CourseEnrolmentDto(courseDto, createdAt));
    }
}
