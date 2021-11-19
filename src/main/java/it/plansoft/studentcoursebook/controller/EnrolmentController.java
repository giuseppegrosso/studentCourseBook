package it.plansoft.studentcoursebook.controller;

import it.plansoft.studentcoursebook.controller.interfaces.IEnrolmentController;
import it.plansoft.studentcoursebook.dto.CourseDto;
import it.plansoft.studentcoursebook.dto.EnrolmentDto;
import it.plansoft.studentcoursebook.dto.StudentDto;
import it.plansoft.studentcoursebook.model.Course;
import it.plansoft.studentcoursebook.model.Enrolment;
import it.plansoft.studentcoursebook.model.Student;
import it.plansoft.studentcoursebook.service.EnrolmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Giuseppe Grosso
 * @project student-course-book
 * @since 18/11/2021
 */
@RestController
@RequestMapping("/enrolment")
public class EnrolmentController implements IEnrolmentController {

    EnrolmentService enrolmentService;

    public EnrolmentController(EnrolmentService enrolmentService) {
        this.enrolmentService = enrolmentService;
    }

    @Override
    public EnrolmentDto addEnrolment(StudentDto studentDto, CourseDto courseDto) {
        return enrolmentService.addEnrolment(studentDto, courseDto);
    }
}
