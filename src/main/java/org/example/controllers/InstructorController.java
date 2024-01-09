package org.example.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.example.models.Instructor;
import org.example.service.InstructorService;

import javax.ws.rs.core.Response;
import java.sql.SQLException;
@Path("/instructors")
@Api(value = "/instructors", description = "REST Endpoints for User Service")
@Produces({"application/json", "application/xml"})
public class InstructorController {

    InstructorService instructorService= new InstructorService();
    @GET
    @Path("/getAllInstructors")
    @ApiOperation(value = "Finds Pets by status",
            notes = "Multiple status values can be provided with comma seperated strings",
            response = Instructor.class,
            responseContainer = "List")
    public Response getMessageInstructors() throws SQLException {
        try {
            return Response.ok(instructorService.getInstructors()).build();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return Response.ok(instructorService.getInstructors()).build();
    }
/*
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
    */

}
