package it.plansoft.studentcoursebook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Enrolment")
@Table(name = "enrolment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enrolment {

    // @Embeddable --> definisce la chiave composta.
    //
    // @EmbeddedId ---> definisce che sto usando una chiave composta.

    // @MapsId("courseId") --> definisce la proprietà java che contiene la referenza alla chiave.


    @EmbeddedId
    private EnrolmentId id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(
            name = "student_id",
            foreignKey = @ForeignKey(
                    name = "enrolment_student_id_fk"
            )
    )
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(
            name = "course_id",
            foreignKey = @ForeignKey(
                    name = "enrolment_course_id_fk"
            )
    )
    private Course course;

    @Column(
            name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP"
    )
    private LocalDateTime createdAt;




    public Enrolment(Student student,
                     Course course,
                     LocalDateTime createdAt) {
        this.student = student;
        this.course = course;
        this.createdAt = createdAt;
    }

}
