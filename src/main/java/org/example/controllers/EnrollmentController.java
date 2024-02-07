package org.example.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

import org.example.service.EnrollmentService;
import org.example.models.Enrollment;

@Path("/enrollments")
public class EnrollmentController {

    EnrollmentService enrollmentService=new EnrollmentService();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Enrollment> getEnrollments() {

            return enrollmentService.getEnrollments();
    }
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteEnrollment(Enrollment enrollment){

            enrollmentService.deleteEnrollment(enrollment);
    }
    //add enrollment
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Enrollment addEnrollment(Enrollment enrollment) {
        return enrollmentService.addEnrollment(enrollment);
    }
}
