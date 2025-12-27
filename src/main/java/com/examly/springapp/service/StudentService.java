package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.Student;

public interface StudentService {

    Student addStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(int id);

    Student updateStudent(int id, Student student);

    Student getStudentByEmail(String email);
}