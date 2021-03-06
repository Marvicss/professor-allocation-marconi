package com.project.professor.allocation.repository;

import com.project.professor.allocation.entity.Course;
import com.project.professor.allocation.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {


    List<Course> findByNameContaining(String partName);
}
