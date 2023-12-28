package org.example.contollers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.models.Instructor;
import org.example.service.InstructorService;

import java.sql.SQLException;
import java.util.List;
@Path("/message")
public class InstructorController {

    InstructorService instructorService= new InstructorService();
    @GET
    @Path("/instructors")
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
    @Path("/instructors")
    @Consumes(MediaType.APPLICATION_JSON)
    public Instructor addInstructor(Instructor instructor) {
        return instructorService.addInstructor(instructor);
    }

    @PUT
    @Path("/instructors/{instructor_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Instructor updateInstructor(@PathParam("instructor_id") int id, Instructor instructor){

        instructor.setEmployee_id(id);
        return instructorService.updateInstructor(instructor);

    }

    @DELETE
    @Path("/instructors/{instructor_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteInstructor(@PathParam("instructor_id") int id, Instructor instructor){

        instructor.setEmployee_id(id);
        try {
            instructorService.deleteInstructor(instructor, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
