package org.example.service;

import org.example.jdbc.DatabaseConnection;
import org.example.models.Enrollment;
import org.example.models.Student;
import org.example.repositories.EnrollmentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentService {

    EnrollmentRepository enrollmentRepository= new EnrollmentRepository();
    public List<Enrollment> getEnrollments() throws SQLException {

        return enrollmentRepository.getEnrollments();
    }
    public Enrollment addEnrollment(Enrollment enrollment){

        enrollmentRepository.addEnrollment(enrollment);

        return enrollment;
    }
    public void deleteEnrollment(Enrollment enrollment) throws SQLException {

        enrollmentRepository.deleteEnrollment(enrollment);
    }
}
