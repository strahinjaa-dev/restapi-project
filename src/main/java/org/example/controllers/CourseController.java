package org.example.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.models.Course;
import org.example.service.CourseService;
import java.sql.SQLException;
import java.util.List;

@Path("/courses")
public class CourseController {
    CourseService courseService= new CourseService();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> getMessageDCourses() throws SQLException {
        try {
            return courseService.getCourses();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return courseService.getCourses();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Course addCourse(Course course){
        return courseService.addCourse(course);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Course updateCourse(Course course){

        return courseService.updateCourse(course);

    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCourse(Course course){

        try {
            courseService.deleteCourse(course);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
