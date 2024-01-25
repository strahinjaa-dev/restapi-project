package org.example.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.service.StudentService;
import org.example.models.Student;
import java.sql.SQLException;
import java.util.List;

@Path("/students")
public class StudentController {

    StudentService studentService= new StudentService();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getMessageStudents() throws SQLException {
        try {
            return studentService.getStudents();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return studentService.getStudents();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Student addStudent(Student student) {
        return studentService.addStudent(student);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Student updateStudent(Student student){
        return studentService.updateStudent(student);
    }
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteStudent(Student student){

        studentService.deleteStudent(student);
    }
}
