package it.plansoft.studentcoursebook.mapper;

import org.mapstruct.Context;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author Giuseppe Grosso
 * @project course
 * @since 16/11/2021
 */
public interface IMapper<DTO, MODEL> {

    DTO toDto(MODEL model, @Context CycleAvoidingMappingContext context);
    MODEL dtoToModel(DTO dto);
    List<DTO> toDtos(List<MODEL> models, @Context CycleAvoidingMappingContext context);
    List<MODEL> toModels(List<DTO> dtos);
    // set
    Set<DTO> toSetDtos(Set<MODEL> model);
    // set
    Set<DTO> toSetDtos(List<MODEL> model);
    // ... aggiungere eventuali altre collection

    Collection<DTO> toDtosNew(List<MODEL> models, @Context CycleAvoidingMappingContext context);
}