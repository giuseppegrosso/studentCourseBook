package it.plansoft.studentcoursebook.mapper;

import it.plansoft.studentcoursebook.dto.BookDto;
import it.plansoft.studentcoursebook.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

/**
 * @author Giuseppe Grosso
 * @project course
 * @since 16/11/2021
 */
@Mapper(componentModel = "spring")
@Named("BookMapper")
public interface IBookMapper extends IMapper<BookDto, Book> {

    IBookMapper INSTANCE = Mappers.getMapper(IBookMapper.class);

}
