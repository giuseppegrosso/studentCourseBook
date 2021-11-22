package it.plansoft.studentcoursebook.controller;

import it.plansoft.studentcoursebook.dto.StudentDto;
import it.plansoft.studentcoursebook.mapper.IStudentMapper;
import it.plansoft.studentcoursebook.model.Student;
import it.plansoft.studentcoursebook.repository.StudentRepository;
import it.plansoft.studentcoursebook.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Giuseppe Grosso
 * @project student-course-book
 * @since 22/11/2021
 */
@RestController
@RequestMapping("/student")
public class StudentController extends BaseCrudController<
        StudentService,
        StudentRepository,
        IStudentMapper,
        StudentDto,
        Student,
        Long> {

    public StudentController(StudentService service) {
        super(service);
    }

}
