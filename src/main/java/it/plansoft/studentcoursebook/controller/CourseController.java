package it.plansoft.studentcoursebook.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import it.plansoft.studentcoursebook.dto.CourseDto;
import it.plansoft.studentcoursebook.dto.StudentDto;
import it.plansoft.studentcoursebook.mapper.ICourseMapper;
import it.plansoft.studentcoursebook.mapper.IStudentMapper;
import it.plansoft.studentcoursebook.model.BaseId;
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
@ApiResponse(description = "API per operazioni di inserimento/modifica/cancellazione/modifica anagrafica corso")
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
