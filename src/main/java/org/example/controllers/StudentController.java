package org.example.contollers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.service.StudentService;
import org.example.models.Student;

import java.sql.SQLException;
import java.util.List;
@Path("/message")
public class StudentController {

    StudentService studentService= new StudentService();
    @GET
    @Path("/students")
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
    @Path("/students")
    @Consumes(MediaType.APPLICATION_JSON)
    public Student addStudent(Student student) {
        return studentService.addStudent(student);
    }

    @PUT
    @Path("/students/{student_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Student updateStudent(@PathParam("student_id") int id, Student student){
        student.setStudent_id(id);
        return studentService.updateStudent(student);
    }
    @DELETE
    @Path("/students/{student_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteStudent(@PathParam("student_id") int id, Student student){
        student.setStudent_id(id);
        try {
            studentService.deleteStudent(student, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
