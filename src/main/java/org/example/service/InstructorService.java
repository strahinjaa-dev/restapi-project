package org.example.service;

import org.example.models.Instructor;
import org.example.repositories.InstructorRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InstructorService {

    InstructorRepository instructorRepository= new InstructorRepository();

    public void deleteInstructor(Instructor instructor, int id) throws SQLException {

        instructorRepository.deleteInstructor(instructor, id);
    }

    public Instructor updateInstructor(Instructor instructor) {

        return instructorRepository.updateInstructor(instructor);
    }

    public Instructor addInstructor(Instructor instructor) {

       return instructorRepository.addInstructor(instructor);
    }

    public List<Instructor> getInstructors() throws SQLException {

       return instructorRepository.getInstructors();
    }
}
