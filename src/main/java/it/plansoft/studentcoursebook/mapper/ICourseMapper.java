package it.plansoft.studentcoursebook.mapper;

import it.plansoft.studentcoursebook.dto.CourseDto;
import it.plansoft.studentcoursebook.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

/**
 * @author Giuseppe Grosso
 * @project course
 * @since 16/11/2021
 */
@Mapper(componentModel = "spring")
@Named("CourseMapper")
public interface ICourseMapper extends IMapper<CourseDto, Course> {

    ICourseMapper INSTANCE = Mappers.getMapper(ICourseMapper.class);

}
