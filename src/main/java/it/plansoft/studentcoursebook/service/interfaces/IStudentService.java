package it.plansoft.studentcoursebook.service.interfaces;

import it.plansoft.studentcoursebook.dto.CourseDto;
import it.plansoft.studentcoursebook.dto.StudentDto;

import java.util.Optional;

/**
 * @author Giuseppe Grosso
 * @project student-course-book
 * @since 18/11/2021
 */
public interface IStudentService {
    StudentDto addStudentCourse(StudentDto student, CourseDto course);

    StudentDto findById(Long idStudent);
}
