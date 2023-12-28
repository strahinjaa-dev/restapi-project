package org.example.contollers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.models.Course;
import org.example.service.CourseService;

import java.sql.SQLException;
import java.util.List;

@Path("/message")
public class CourseController {
    CourseService courseService= new CourseService();
    @GET
    @Path("/courses")
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
    @Path("/courses")
    @Consumes(MediaType.APPLICATION_JSON)
    public Course addCourse(Course course){
        return courseService.addCourse(course);
    }

    @PUT
    @Path("/courses/{courseid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Course updateCourse(@PathParam("courseid") int id, Course course){

        course.setCourse_id(id);
        return courseService.updateCourse(course);

    }

    @DELETE
    @Path("/courses/{courseid}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCourse(@PathParam("courseid") int id, Course course){

        course.setCourse_id(id);
        try {
            courseService.deleteCourse(course, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
