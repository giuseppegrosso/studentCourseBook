package it.plansoft.studentcoursebook.service;

import it.plansoft.studentcoursebook.dto.CourseDto;
import it.plansoft.studentcoursebook.mapper.ICourseMapper;
import it.plansoft.studentcoursebook.model.Course;
import it.plansoft.studentcoursebook.repository.CourseRepository;
import it.plansoft.studentcoursebook.service.interfaces.ICourseService;
import org.springframework.stereotype.Service;

/**
 * @author Giuseppe Grosso
 * @project Course-course-book
 * @since 22/11/2021
 */
@Service
public class CourseService
        extends BaseCrudService
        <CourseRepository,
                ICourseMapper,
                CourseDto,
                Course,
                Long>
        implements ICourseService {

    public CourseService(CourseRepository repository) {
        super(repository, ICourseMapper.INSTANCE);
    }
}
