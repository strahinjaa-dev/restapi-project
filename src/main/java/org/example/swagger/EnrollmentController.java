package org.example.swagger;



import org.example.service.EnrollmentService;
import org.example.models.Enrollment;


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

@Path("/enrollments")
public class EnrollmentController {

    EnrollmentService enrollmentService=new EnrollmentService();
    @GET
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
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteEnrollment(Enrollment enrollment){


        try {
            enrollmentService.deleteEnrollment(enrollment);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //add enrollment
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Enrollment addEnrollment(Enrollment enrollment) {
        return enrollmentService.addEnrollment(enrollment);
    }
}