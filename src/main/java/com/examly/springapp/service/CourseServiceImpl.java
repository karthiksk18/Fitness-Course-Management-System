package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Course;
import com.examly.springapp.repository.CourseRepo;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public Course addCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public Course getCourseById(int id) {
        return courseRepo.findById(id).orElse(null);
    }

    @Override
    public Course updateCourse(int id, Course course) {
        Course existing = courseRepo.findById(id).orElse(null);
        if (existing != null) {
            existing.setCourseName(course.getCourseName());
            existing.setDescription(course.getDescription());
            existing.setDuration(course.getDuration());
            existing.setPrice(course.getPrice());
            existing.setLevel(course.getLevel());
            existing.setInstructor(course.getInstructor());
            return courseRepo.save(existing);
        }
        return null;
    }

    @Override
    public List<Course> getCoursesByInstructor(int instructorId) {
        return courseRepo.findByInstructorInstructorId(instructorId);
    }

    @Override
    public List<Course> getCoursesByLevel(String level) {
        return courseRepo.findByLevel(level);
    }
}
