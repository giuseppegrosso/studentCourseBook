package it.plansoft.studentcoursebook.controller;

import it.plansoft.studentcoursebook.dto.CourseDto;
import it.plansoft.studentcoursebook.dto.StudentDto;
import it.plansoft.studentcoursebook.mapper.ICourseMapper;
import it.plansoft.studentcoursebook.mapper.IStudentMapper;
import it.plansoft.studentcoursebook.model.Course;
import it.plansoft.studentcoursebook.model.Student;
import it.plansoft.studentcoursebook.repository.CourseRepository;
import it.plansoft.studentcoursebook.repository.StudentRepository;
import it.plansoft.studentcoursebook.service.CourseService;
import it.plansoft.studentcoursebook.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Giuseppe Grosso
 * @project student-course-book
 * @since 22/11/2021
 */
@RestController
@RequestMapping("/course")
public class CourseController extends BaseCrudController<
        CourseService,
        CourseRepository,
        ICourseMapper,
        CourseDto,
        Course,
        Long> {

    public CourseController(CourseService service) {
        super(service);
    }

}
