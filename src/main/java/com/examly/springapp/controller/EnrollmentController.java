package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @GetMapping
    public String getEnrollments() {
        return "Enrollments";
    }
}
