package it.plansoft.studentcoursebook.controller.interfaces;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import it.plansoft.studentcoursebook.dto.StudentDto;
import it.plansoft.studentcoursebook.dto.StudentEnrolmentCourseDto;
import it.plansoft.studentcoursebook.model.BaseId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Giuseppe Grosso
 * @project student-course-book
 * @since 18/11/2021
 */
public interface IStudentCourseEnrolmentController {

    @Operation(summary = "Enrolment of student to a course")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found items",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BaseId.class))}),
            @ApiResponse(responseCode = "400", description = "invalid items",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "items not found",
                    content = @Content)})
    StudentEnrolmentCourseDto addEnrolment(StudentEnrolmentCourseDto studentEnrolmentCourseDto);

    @Operation(summary = "Get Student enrolment course")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found items",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BaseId.class))}),
            @ApiResponse(responseCode = "400", description = "invalid items",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "items not found",
                    content = @Content)})
    StudentEnrolmentCourseDto addEnrolment(@PathVariable Long id);
}
