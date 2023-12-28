package org.example.service;

import org.example.jdbc.DatabaseConnection;
import org.example.models.Course;
import org.example.repositories.CourseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseService {

    CourseRepository courseRepository= new CourseRepository();

    public void deleteCourse(Course course, int id) throws SQLException {

        courseRepository.deleteCourse(course, id);
    }

    public Course updateCourse(Course course) {

        return courseRepository.updateCourse(course);
    }

    public Course addCourse(Course course) {

      return courseRepository.addCourse(course);
    }

    public List<Course> getCourses() throws SQLException {

        return courseRepository.getCourses();
    }
}
