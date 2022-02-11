package com.project.professor.allocation.service;
import com.project.professor.allocation.entity.Allocation;
import com.project.professor.allocation.entity.Course;
import com.project.professor.allocation.entity.Professor;
import com.project.professor.allocation.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private CourseRepository courseRepository;


    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    public Course findById(Long id){

        Optional <Course> courseOptional = courseRepository.findById(id);
        Course course = courseOptional.orElse(null);
        return course;


    }

    public List<Course> findAll(String name)
    {
        if ( name != null){

            List<Course> courses = courseRepository.findAll();
            return courses;
        }

        else{
            List<Course> courses = courseRepository.findByNameContaining(name);
            return courses;
        }


    }

    public Course create(Course course)
    {
        course.setId(null);
        Course courseNew = courseRepository.save(course);
        return courseNew;
    }

    public Course update(Course course)
    {
        Long id = course.getId();

        if (id != null && courseRepository.existsById(id))
        {
            Course courseNew = courseRepository.save(course);
            return courseNew;
        }
        else
        {
            return null;
        }
    }

    public void deleteById(Long id)
    {
        if (id != null && courseRepository.existsById(id))
        {
            courseRepository.deleteById(id);
        }
    }

    public void deleteAll()
    {
        courseRepository.deleteAll();
    }

}

