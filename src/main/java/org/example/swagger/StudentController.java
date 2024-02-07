package org.example.swagger;



import org.example.models.Student;
import org.example.service.StudentService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/students")
public class StudentController {

    StudentService studentService= new StudentService();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getMessageStudents()  {

        return studentService.getStudents();
    }
    @POST
    @Consumes(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public Student addStudent(Student student) {
        return studentService.addStudent(student);
    }

    @PUT
    @Consumes(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public Student updateStudent(Student student){
        return studentService.updateStudent(student);
    }
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteStudent(Student student){

        studentService.deleteStudent(student);
    }
}