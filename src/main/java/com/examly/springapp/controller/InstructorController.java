package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Instructor;
import com.examly.springapp.service.InstructorService;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @PostMapping
    public ResponseEntity<Instructor> createInstructor(
            @RequestBody Instructor instructor) {

        Instructor savedInstructor = instructorService.addInstructor(instructor);
        return new ResponseEntity<>(savedInstructor, HttpStatus.CREATED);
    }
     @GetMapping
    public ResponseEntity<List<Instructor>> getAllInstructors() {

        List<Instructor> instructors = instructorService.getAllInstructors();

        if (instructors == null || instructors.isEmpty()) {
            return ResponseEntity.noContent().build(); 
        }

        return ResponseEntity.ok(instructors); 
    }
   @GetMapping("/{id}")
    public ResponseEntity<Instructor> getInstructorById(
            @PathVariable int id) {

        Instructor instructor = instructorService.getInstructorById(id);

        if (instructor == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(instructor);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Instructor> updateInstructor(
            @PathVariable int id,
            @RequestBody Instructor instructor) {

        Instructor updatedInstructor =
                instructorService.updateInstructor(id, instructor);

        if (updatedInstructor == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedInstructor);
    }
     @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable int id) {
        return ResponseEntity.noContent().build();
    }
@GetMapping("/page/{page}/{size}")
    public ResponseEntity<Page<Instructor>> getInstructorsWithPagination(
            @PathVariable int page,
            @PathVariable int size) {

        Page<Instructor> instructorPage =
                instructorService.getInstructorsWithPagination(page, size);

        return ResponseEntity.ok(instructorPage);
    }
 @GetMapping("/specialization/{specialization}")
public ResponseEntity<?> getInstructorsBySpecialization(
        @PathVariable String specialization) {

    List<Instructor> instructors =
            instructorService.getInstructorsBySpecialization(specialization);

    if (instructors == null || instructors.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No instructors found with specialization: " + specialization);
    }
    return ResponseEntity.ok(instructors);
}


}
