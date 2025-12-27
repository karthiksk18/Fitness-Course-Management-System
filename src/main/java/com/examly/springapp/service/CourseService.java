package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.Course;

public interface CourseService {

    Course addCourse(Course course);

    List<Course> getAllCourses();

    Course getCourseById(int id);

    Course updateCourse(int id, Course course);

    List<Course> getCoursesByInstructor(int instructorId);

    List<Course> getCoursesByLevel(String level);
}
