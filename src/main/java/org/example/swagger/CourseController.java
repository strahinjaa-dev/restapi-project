package org.example.swagger;


import org.example.models.Course;
import org.example.service.CourseService;

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

@Path("/courses")
public class CourseController {
    CourseService courseService= new CourseService();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> getMessageDCourses() {

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
    public Course updateCourse( Course course){

        return courseService.updateCourse(course);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCourse(Course course){

            courseService.deleteCourse(course);
    }
}

