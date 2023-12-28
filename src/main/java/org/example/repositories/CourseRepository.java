package org.example.repositories;

import org.example.jdbc.DatabaseConnection;
import org.example.models.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository {

    Connection connection = DatabaseConnection.getConnection();

    public void deleteCourse(Course course, int id) throws SQLException {

        try {
            Statement statement = connection.createStatement();

            String sqlQuery = "DELETE FROM courses WHERE course_id = " + id;

            statement.executeUpdate(sqlQuery);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Course updateCourse(Course course) {

        try {
            Statement statement = connection.createStatement();

            Integer id = course.getCourse_id();
            String name = course.getCourse_name();
            Integer department_id_fk = course.getDepartment_id_fk();


            String sqlQuery = "UPDATE courses SET course_name = ?, department_id_fk = ? WHERE course_id = " + id;

            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {

                preparedStatement.setString(1, name);
                preparedStatement.setInt(2, department_id_fk);


                int affectedRows = preparedStatement.executeUpdate();
                System.out.println("Broj ažuriranih redova: " + affectedRows);
            }

            catch (SQLException e) {
                e.printStackTrace();
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return course;
    }

    public Course addCourse(Course course) {

        try {
            //department_id_fk
            String insertQuery = "INSERT INTO courses ( course_name) VALUES ( ? )";

            String name = course.getCourse_name();
            Integer department_id_fk = course.getDepartment_id_fk();

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, name);
                // preparedStatement.setInt(2, department_id_fk);


                int affectedRows = preparedStatement.executeUpdate();

                if (affectedRows > 0) {
                    System.out.println("Podaci uspesno uneseni u bazu.");
                } else {
                    System.out.println("Nije uspelo uneti podatke u bazu.");
                }
            }

            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return course;
    }

    public List<Course> getCourses() throws SQLException {

        List<Course> courses = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();

            String query = "select * from courses";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int course_id = resultSet.getInt("course_id");
                String course_name = resultSet.getString("course_name");
               // Integer department_id_fk = resultSet.getInt("department_id_fk");

                Course c = new Course(course_id, course_name,-1);

                courses.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courses;
    }
}
