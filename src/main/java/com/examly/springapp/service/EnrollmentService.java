package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.Enrollment;

public interface EnrollmentService {
    
    Enrollment addEnrollment(Enrollment enrollment);
    List<Enrollment> getAllEnrollments();
    Enrollment getEnrollmentById(long id);
}
