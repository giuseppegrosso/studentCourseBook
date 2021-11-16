package it.plansoft.studentcoursebook.controller.interfaces;/* ggrosso created on 21/02/2021 inside the package - it.plansoft.demojpa.controller.interfaces */

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import it.plansoft.studentcoursebook.model.BaseId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ICrudController<DTO, ID> {

    // esempio di annotazioni
    @Operation(summary = "Get all item")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found items",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BaseId.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "items not found",
                    content = @Content) })
    ResponseEntity<List<DTO>> findAll();

    @Operation(summary = "Get all item pageable")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found items",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BaseId.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "items not found",
                    content = @Content) })
    ResponseEntity<Page<DTO>> findAll(Pageable pageable);

    @Operation(summary = "Get item by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found items",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BaseId.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "items not found",
                    content = @Content) })
    ResponseEntity<Optional<DTO>> findById(ID id);

    ResponseEntity<DTO> save(DTO DTO);

    ResponseEntity<List<DTO>> saveAll(List<DTO> DTO);

    ResponseEntity<Optional<DTO>> delete(DTO DTO);

    ResponseEntity<Optional<DTO>> deleteById(ID id);

    ResponseEntity<DTO> update(DTO DTO);


}
