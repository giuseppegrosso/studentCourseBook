package it.plansoft.studentcoursebook.mapper;

import it.plansoft.studentcoursebook.dto.StudentDto;
import it.plansoft.studentcoursebook.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

/**
 * @author Giuseppe Grosso
 * @project course
 * @since 16/11/2021
 */
@Mapper(componentModel = "spring")
@Named("StudentMapper")
public interface IStudentMapper extends IMapper<StudentDto, Student> {

    IStudentMapper INSTANCE = Mappers.getMapper(IStudentMapper.class);

}
