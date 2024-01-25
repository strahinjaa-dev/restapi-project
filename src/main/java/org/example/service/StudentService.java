package org.example.service;

import org.example.models.Student;
import org.example.jdbc.DatabaseConnection;
import org.example.models.Enrollment;
import org.example.repositories.StudentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class StudentService {


    StudentRepository studentRepository= new StudentRepository();
    Connection connection = DatabaseConnection.getConnection();


    public void deleteStudent(Student student) {

        try {
             studentRepository.deleteStudentByID(student);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Student updateStudent(Student student){

       return studentRepository.updateStudent(student);
    }

    public Student addStudent(Student student){

       return studentRepository.addStudent(student);
    }
    public List<Student> getStudents() throws SQLException{

       return studentRepository.getAllStudents();
    }
}
