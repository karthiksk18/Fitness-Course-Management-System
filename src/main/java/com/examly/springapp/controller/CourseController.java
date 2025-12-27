package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Course;
import com.examly.springapp.service.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(courseService.addCourse(course));
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable int id) {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(
            @PathVariable int id,
            @RequestBody Course course) {
        return ResponseEntity.ok(courseService.updateCourse(id, course));
    }

    @GetMapping("/instructor/{id}")
    public ResponseEntity<List<Course>> getCoursesByInstructor(
            @PathVariable int id) {
        return ResponseEntity.ok(courseService.getCoursesByInstructor(id));
    }

    @GetMapping("/level/{level}")
    public ResponseEntity<?> getCoursesByLevel(@PathVariable String level) {
        List<Course> list = courseService.getCoursesByLevel(level);
        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("No courses found at level: " + level);
        }
        return ResponseEntity.ok(list);
    }
}
