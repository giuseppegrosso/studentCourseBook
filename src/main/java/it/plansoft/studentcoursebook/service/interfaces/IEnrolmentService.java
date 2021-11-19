package it.plansoft.studentcoursebook.service.interfaces;

import it.plansoft.studentcoursebook.dto.CourseDto;
import it.plansoft.studentcoursebook.dto.EnrolmentDto;
import it.plansoft.studentcoursebook.dto.StudentDto;

/**
 * @author Giuseppe Grosso
 * @project student-course-book
 * @since 18/11/2021
 */
public interface IEnrolmentService {
    EnrolmentDto addEnrolment(StudentDto student, CourseDto course);
}
