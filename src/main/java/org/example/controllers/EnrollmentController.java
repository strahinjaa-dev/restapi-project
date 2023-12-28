package org.example.contollers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.service.EnrollmentService;
import org.example.models.Enrollment;
import org.example.models.Student;

import java.sql.SQLException;
import java.util.List;

@Path("/message")
public class EnrollmentController {

    EnrollmentService enrollmentService=new EnrollmentService();
    @GET
    @Path("/enrollments")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Enrollment> getEnrollments() {
        try {
            return enrollmentService.getEnrollments();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            return enrollmentService.getEnrollments();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @DELETE
    @Path("/students/{student_id}/enrollments/{course_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteInstructor(@PathParam("student_id") int student_id,
                                 @PathParam("course_id") int course_id, Student student){

        student.setStudent_id(student_id);
        try {
            enrollmentService.deleteEnrollment(student, student_id,course_id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //add enrollment
    @POST
    @Path("/students/{student_id}/enrollments/{course_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Enrollment addEnrollment(@PathParam("student_id") int student_id,
                                    @PathParam("course_id") int course_id) {
        return enrollmentService.addEnrollment(student_id,course_id);
    }
}
