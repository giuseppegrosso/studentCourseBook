package it.plansoft.studentcoursebook.service;

import it.plansoft.studentcoursebook.dto.CourseDto;
import it.plansoft.studentcoursebook.dto.StudentDto;
import it.plansoft.studentcoursebook.mapper.ICourseMapper;
import it.plansoft.studentcoursebook.mapper.IStudentMapper;
import it.plansoft.studentcoursebook.model.Course;
import it.plansoft.studentcoursebook.model.Enrolment;
import it.plansoft.studentcoursebook.model.EnrolmentId;
import it.plansoft.studentcoursebook.model.Student;
import it.plansoft.studentcoursebook.repository.CourseRepository;
import it.plansoft.studentcoursebook.repository.EnrolmentRepository;
import it.plansoft.studentcoursebook.repository.StudentRepository;
import it.plansoft.studentcoursebook.service.interfaces.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author Giuseppe Grosso
 * @project student-course-book
 * @since 18/11/2021
 */
@Service
@Transactional
public class StudentService
        extends BaseCrudService<StudentRepository,
        IStudentMapper,
        StudentDto,
        Student,
        Long>
        implements IStudentService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private EnrolmentRepository enrolmentRepository;

    public StudentService(StudentRepository studentRepository) {
        super(studentRepository, IStudentMapper.INSTANCE);
    }


    @Override
    public StudentDto addEnrolment(StudentDto studentDto) {
        Student student = IStudentMapper.INSTANCE.dtoToModel(studentDto);
        StudentDto retDto = null;
        if (studentDto.getCourseDtos() != null) {

            // check if exist student
            if (student.getId() != null) {
                // read student in database
                student = repository.getById(student.getId());
            } else
                student = repository.save(student);


            for (CourseDto courseDto : studentDto.getCourseDtos()) {

                Course course = ICourseMapper.INSTANCE.dtoToModel(courseDto);

                if (course.getId() != null) {
                    // read course in database
                    course = courseRepository.getById(course.getId());
                } else
                    course = courseRepository.save(course);

                // save enrollment
                EnrolmentId enrolmentId = new EnrolmentId(student.getId(), course.getId());
                Enrolment enrolmentSaved = enrolmentRepository.save(new Enrolment(enrolmentId,
                        student,
                        course,
                        courseDto.getEnrolmentAt() != null ? courseDto.getEnrolmentAt() : LocalDateTime.now()));

                // add enrollment
                student.addEnrolment(enrolmentSaved);

            }
            // save the student
            student = repository.save(student);

            //some logic with result and return it
            retDto = readFromStudent(student);
        }
        return retDto;
    }


    @Override
    public Optional<StudentDto> findById(Long idStudent) {
        return repository.findById(idStudent)
                .map(s -> {
                    return readFromStudent(s);
                });

    }


    private StudentDto readFromStudent(Student student) {
        StudentDto retDto = new StudentDto(student.getId(), student.getFirstName(),
                student.getLastName(), student.getEmail(), student.getAge(), student.getStudentIdCard() != null ? student.getStudentIdCard().getCardNumber() : "");

        // convert data to dto: enrollment
        student.getEnrolments().stream().forEach(x -> {
            retDto.addCourse(new CourseDto(x.getCourse().getId(), x.getCourse().getName(), x.getCourse().getDepartment(), x.getCreatedAt()));
        });

        return retDto;
    }
}
