package it.plansoft.studentcoursebook.service.interfaces;

import it.plansoft.studentcoursebook.dto.CourseEnrolmentDto;
import it.plansoft.studentcoursebook.dto.StudentDto;
import it.plansoft.studentcoursebook.dto.StudentEnrolmentCourseDto;

import java.util.List;

/**
 * @author Giuseppe Grosso
 * @project student-course-book
 * @since 18/11/2021
 */
public interface IStudentService {

    StudentEnrolmentCourseDto addEnrolment(StudentDto studentDto, List<CourseEnrolmentDto> courseEnrolmentDtoList);

    StudentEnrolmentCourseDto findByIdStudent(Long idStudent);
}
