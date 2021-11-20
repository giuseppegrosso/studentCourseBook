package it.plansoft.studentcoursebook.controller;

import it.plansoft.studentcoursebook.controller.interfaces.IStudentController;
import it.plansoft.studentcoursebook.dto.StudentCourseEnrolmentDto;
import it.plansoft.studentcoursebook.dto.StudentDto;
import it.plansoft.studentcoursebook.mapper.IMapper;
import it.plansoft.studentcoursebook.mapper.IStudentMapper;
import it.plansoft.studentcoursebook.model.BaseId;
import it.plansoft.studentcoursebook.model.Student;
import it.plansoft.studentcoursebook.repository.StudentRepository;
import it.plansoft.studentcoursebook.service.BaseCrudService;
import it.plansoft.studentcoursebook.service.StudentService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

/**
 * @author Giuseppe Grosso
 * @project student-course-book
 * @since 18/11/2021
 */
@RestController
@RequestMapping("/student")
public class StudentController extends BaseCrudController<StudentService,
        StudentRepository,
        IStudentMapper,
        StudentDto,
        Student,
        Long>
        implements IStudentController {

    public StudentController(StudentService studentService) {
        super(studentService);
    }

    @PostMapping("/enrolCourse")
    @Override
    public StudentDto addEnrolment(@RequestBody StudentDto studentDto) {
        return service.addEnrolment(studentDto);
    }
}
