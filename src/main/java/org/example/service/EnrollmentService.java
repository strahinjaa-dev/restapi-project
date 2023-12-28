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
    public Enrollment addEnrollment(Integer student_id, Integer course_id){

        enrollmentRepository.addEnrollment(student_id,course_id);
        Enrollment e= new Enrollment(student_id, course_id);
        return e;
    }
    public void deleteEnrollment(Student student, int student_id, int course_id) throws SQLException {

        enrollmentRepository.deleteEnrollment(student, student_id, course_id);
    }
}
