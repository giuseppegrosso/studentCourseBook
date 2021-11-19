package it.plansoft.studentcoursebook.controller.interfaces;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import it.plansoft.studentcoursebook.dto.CourseDto;
import it.plansoft.studentcoursebook.dto.EnrolmentDto;
import it.plansoft.studentcoursebook.dto.StudentDto;
import it.plansoft.studentcoursebook.model.BaseId;

/**
 * @author Giuseppe Grosso
 * @project student-course-book
 * @since 18/11/2021
 */
public interface IEnrolmentController {

    @Operation(summary = "Enrolment of student to a course")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found items",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BaseId.class)) }),
            @ApiResponse(responseCode = "400", description = "invalid items",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "items not found",
                    content = @Content) })
    EnrolmentDto addEnrolment(StudentDto student, CourseDto course);
}
