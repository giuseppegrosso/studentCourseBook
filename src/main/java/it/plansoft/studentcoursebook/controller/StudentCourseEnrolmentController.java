package it.plansoft.studentcoursebook.controller;

import it.plansoft.studentcoursebook.controller.interfaces.IStudentCourseEnrolmentController;
import it.plansoft.studentcoursebook.dto.StudentEnrolmentCourseDto;
import it.plansoft.studentcoursebook.service.StudentService;
import org.springframework.web.bind.annotation.*;

/**
 * @author Giuseppe Grosso
 * @project student-course-book
 * @since 18/11/2021
 */
@RestController
@RequestMapping("/courseEnrolment")
public class StudentCourseEnrolmentController
        implements IStudentCourseEnrolmentController {

    StudentService studentService;

    public StudentCourseEnrolmentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/enrolCourse")
    @Override
    public StudentEnrolmentCourseDto addEnrolment(@RequestBody StudentEnrolmentCourseDto studentEnrolmentCourseDto) {
        return studentService.addEnrolment(studentEnrolmentCourseDto.getStudentDto(), studentEnrolmentCourseDto.getCourseEnrolmentDto());
    }

    @GetMapping("/enrolCourse/{id}/student")
    @Override
    public StudentEnrolmentCourseDto addEnrolment(@PathVariable Long id) {
        return studentService.findByIdStudent(id);
    }
}
