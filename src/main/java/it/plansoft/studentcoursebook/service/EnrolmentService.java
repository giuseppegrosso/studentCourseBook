package it.plansoft.studentcoursebook.service;

import it.plansoft.studentcoursebook.dto.CourseDto;
import it.plansoft.studentcoursebook.dto.EnrolmentDto;
import it.plansoft.studentcoursebook.dto.StudentDto;
import it.plansoft.studentcoursebook.mapper.CycleAvoidingMappingContext;
import it.plansoft.studentcoursebook.mapper.ICourseMapper;
import it.plansoft.studentcoursebook.mapper.IEnrolmentMapper;
import it.plansoft.studentcoursebook.mapper.IStudentMapper;
import it.plansoft.studentcoursebook.model.Course;
import it.plansoft.studentcoursebook.model.Enrolment;
import it.plansoft.studentcoursebook.model.EnrolmentId;
import it.plansoft.studentcoursebook.model.Student;
import it.plansoft.studentcoursebook.repository.CourseRepository;
import it.plansoft.studentcoursebook.repository.EnrolmentRepository;
import it.plansoft.studentcoursebook.repository.StudentRepository;
import it.plansoft.studentcoursebook.service.interfaces.IEnrolmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

/**
 * @author Giuseppe Grosso
 * @project student-course-book
 * @since 18/11/2021
 */
@Service
@AllArgsConstructor
@Transactional
public class EnrolmentService implements IEnrolmentService {

    private StudentRepository studentRepository;
    private CourseRepository courseRepository;
    private EnrolmentRepository enrolmentRepository;

    @Override
    public EnrolmentDto addEnrolment(StudentDto studentDto, CourseDto courseDto) {
        Student student = IStudentMapper.INSTANCE.dtoToModel(studentDto);
        Course course = ICourseMapper.INSTANCE.dtoToModel(courseDto);

        // check if exist student
        if (student.getId() != null) {
            // read student in database
            student = studentRepository.getById(student.getId());
        } else
            student = studentRepository.save(student);

        if (course.getId() != null) {
            // read course in database
            course = courseRepository.getById(student.getId());
        } else
            course = courseRepository.save(course);

        // save enrollment
        EnrolmentId enrolmentId = new EnrolmentId(student.getId(), course.getId());
        Enrolment enrolmentSaved = enrolmentRepository.save(new Enrolment(enrolmentId,
                student,
                course,
                LocalDateTime.now()));

        return IEnrolmentMapper.INSTANCE.toDto(enrolmentSaved, new CycleAvoidingMappingContext());
    }
}
