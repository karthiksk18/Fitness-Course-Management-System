// package com.examly.springapp.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import com.examly.springapp.model.Instructor;
// import com.examly.springapp.service.InstructorService;

// @RestController
// @RequestMapping("/api/instructors")
// public class InstructorController {

//     @Autowired
//     private InstructorService instructorService;

//     @PostMapping
//     public ResponseEntity<Instructor> createInstructor(
//             @RequestBody Instructor instructor) {

//         Instructor savedInstructor = instructorService.addInstructor(instructor);
//         return new ResponseEntity<>(savedInstructor, HttpStatus.CREATED);
//     }
