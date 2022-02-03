package com.project.professor.allocation.service;

import com.project.professor.allocation.entity.Department;
import com.project.professor.allocation.entity.Professor;
import com.project.professor.allocation.repository.CourseRepository;
import com.project.professor.allocation.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;
    private CourseRepository courseRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department findById(Long id)
    {
        Optional<Department> departmentOptional = departmentRepository.findById(id);
        Department department = departmentOptional.orElse(null);
        return department;
    }

    public List<Department> findAll()
    {
        List<Department> departments = departmentRepository.findAll();
        return departments;
    }

    public Department create(Department department)
    {
        department.setId(null);
        Department departmentNew = departmentRepository.save(department);
        return departmentNew;
    }

    public Department update(Department department)
    {
        Long id = department.getId();

        if (id != null && departmentRepository.existsById(id))
        {
            Department departmentNew= departmentRepository.save(department);
            return departmentNew;
        }
        else
        {
            return null;
        }
    }

    public void deleteById(Long id)
    {
        if (id != null && departmentRepository.existsById(id))
        {
            departmentRepository.deleteById(id);
        }
    }

    public void deleteAll()
    {
        departmentRepository.deleteAll();
    }


}