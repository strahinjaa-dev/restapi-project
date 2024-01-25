package org.example.controllers;

import org.example.models.Instructor;
import org.example.service.InstructorService;
import jakarta.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;


@Path("/instructors")
public class InstructorController {

    InstructorService instructorService= new InstructorService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Instructor> getMessageInstructors() throws SQLException {
        try {
            return instructorService.getInstructors();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return instructorService.getInstructors();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Instructor addInstructor(Instructor instructor) {
        return instructorService.addInstructor(instructor);
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Instructor updateInstructor( Instructor instructor){

        return instructorService.updateInstructor(instructor);

    }
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteInstructor(Instructor instructor){

        try {
            instructorService.deleteInstructor(instructor);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
