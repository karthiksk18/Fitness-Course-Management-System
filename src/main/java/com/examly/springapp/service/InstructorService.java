package com.examly.springapp.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.examly.springapp.model.Instructor;

public interface InstructorService {

    Instructor addInstructor(Instructor instructor);

    List<Instructor> getAllInstructors();

    Instructor getInstructorById(int id);

    Instructor updateInstructor(int id, Instructor instructor);

    Page<Instructor> getInstructorsWithPagination(int page, int size);

    List<Instructor> getInstructorsBySpecialization(String specialization);
}
