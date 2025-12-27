package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Student;
import com.examly.springapp.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepo.findById(id).orElse(null);
    }

    @Override
    public Student updateStudent(int id, Student student) {
        Student existing = studentRepo.findById(id).orElse(null);
        if (existing != null) {
            existing.setStudentName(student.getStudentName());
            existing.setEmail(student.getEmail());
            existing.setPhoneNumber(student.getPhoneNumber());
            existing.setAddress(student.getAddress());
            return studentRepo.save(existing);
        }
        return null;
    }

    @Override
    public Student getStudentByEmail(String email) {
        return studentRepo.findByEmail(email);
    }
}
