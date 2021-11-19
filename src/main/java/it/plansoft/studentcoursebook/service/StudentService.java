package it.plansoft.studentcoursebook.service;

import it.plansoft.studentcoursebook.dto.CourseDto;
import it.plansoft.studentcoursebook.dto.EnrolmentDto;
import it.plansoft.studentcoursebook.dto.EnrolmentIdDto;
import it.plansoft.studentcoursebook.dto.StudentDto;
import it.plansoft.studentcoursebook.mapper.CycleAvoidingMappingContext;
import it.plansoft.studentcoursebook.mapper.ICourseMapper;
import it.plansoft.studentcoursebook.mapper.IStudentMapper;
import it.plansoft.studentcoursebook.model.*;
import it.plansoft.studentcoursebook.repository.CourseRepository;
import it.plansoft.studentcoursebook.repository.EnrolmentRepository;
import it.plansoft.studentcoursebook.repository.StudentRepository;
import it.plansoft.studentcoursebook.service.interfaces.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

/**
 * @author Giuseppe Grosso
 * @project student-course-book
 * @since 18/11/2021
 */
@Service
@AllArgsConstructor
@Transactional
public class StudentService implements IStudentService {

    private StudentRepository studentRepository;
    private CourseRepository courseRepository;
    private EnrolmentRepository enrolmentRepository;

    @Override
    public StudentDto addStudentCourse(StudentDto studentDto, CourseDto courseDto) {
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

        // add enrollment
        student.addEnrolment(enrolmentSaved);

        // save the student
        student = studentRepository.save(student);

         //some logic with result and return it
        StudentDto retDto = new StudentDto(student.getId(), student.getFirstName(),
                student.getLastName(), student.getEmail(), student.getAge(), student.getStudentIdCard(), student.getBooks());

        // convert data to dto: enrollment
        student.getEnrolments().stream().forEach(x -> {
            studentDto.addCourse(x.getCourse(), x.getCreatedAt());
        });

        return retDto;
    }

    @Override
    public StudentDto findById(Long idStudent) {
        return studentRepository.findById(idStudent)
                .map(s -> {

                    //some logic with result and return it
                    StudentDto studentDto = new StudentDto(s.getId(), s.getFirstName(), s.getLastName(), s.getEmail(), s.getAge(), s.getStudentIdCard(), s.getBooks());

                    // convert data to dto: enrollment
                    s.getEnrolments().stream().forEach(x -> {
                        studentDto.addCourse(x.getCourse(), x.getCreatedAt());
                    });

                    return studentDto;
                }).get();

    }
}
