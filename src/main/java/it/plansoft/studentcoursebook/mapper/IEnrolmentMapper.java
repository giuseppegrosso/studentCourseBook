package it.plansoft.studentcoursebook.mapper;

import it.plansoft.studentcoursebook.dto.EnrolmentDto;
import it.plansoft.studentcoursebook.model.Enrolment;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

/**
 * @author Giuseppe Grosso
 * @project course
 * @since 16/11/2021
 */
@Mapper(componentModel = "spring")
@Named("EnrolmentMapper")
public interface IEnrolmentMapper extends IMapper<EnrolmentDto, Enrolment> {

    IEnrolmentMapper INSTANCE = Mappers.getMapper(IEnrolmentMapper.class);

}
