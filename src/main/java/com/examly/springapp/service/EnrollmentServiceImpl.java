package com.examly.springapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.Enrollment;
import com.examly.springapp.repository.EnrollmentRepo;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
    
    @Autowired
    private EnrollmentRepo enrollmentRepo;
    
    @Override
    public Enrollment addEnrollment(Enrollment enrollment) {
        return enrollmentRepo.save(enrollment);
    }
    
    @Override
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepo.findAll();
    }
    
    @Override
    public Enrollment getEnrollmentById(long id) {
        return enrollmentRepo.findById(id).orElse(null);
    }
}
