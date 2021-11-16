package it.plansoft.studentcoursebook.repository;

import it.plansoft.studentcoursebook.model.StudentIdCard;
import org.springframework.data.repository.CrudRepository;

public interface StudentIdCardRepository
        extends CrudRepository<StudentIdCard, Long> {
}
