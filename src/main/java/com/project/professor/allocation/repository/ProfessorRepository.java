package com.project.professor.allocation.repository;

import com.project.professor.allocation.entity.Allocation;
import com.project.professor.allocation.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    List<Professor> findByDepartmentId  (Long ProfessorId);

    List<Professor> findByNameContaining (String partName);

}
