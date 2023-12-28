package org.example.repositories;

import org.example.jdbc.DatabaseConnection;
import org.example.models.Enrollment;
import org.example.models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentRepository {

    Connection connection = DatabaseConnection.getConnection();

    public List<Enrollment> getEnrollments() throws SQLException {

        List<Enrollment> enrollments = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();

            String query = "select * from enrollments";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Integer course_id = resultSet.getInt("course_id_fk_pk");
                Integer student_id = resultSet.getInt("student_id_fk_pk");
                Enrollment e = new Enrollment(course_id, student_id);

                enrollments.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return enrollments;
    }
    public Enrollment addEnrollment(Integer student_id, Integer course_id){

        try  {

            // SQL upit za unos podataka
            String insertQuery = "INSERT INTO enrollments (student_id_fk_pk, course_id_fk_pk) VALUES ( ?, ? )";

            // Priprema SQL naredbe s parametrima
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                //preparedStatement.setInt(1, id);
                preparedStatement.setInt(1, student_id);
                preparedStatement.setInt(2, course_id);

                // Izvršavanje upita za unos
                int affectedRows = preparedStatement.executeUpdate();

                if (affectedRows > 0) {
                    System.out.println("Podaci uspešno uneseni u bazu.");
                } else {
                    System.out.println("Nije uspelo uneti podatke u bazu.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        Enrollment e= new Enrollment(student_id, course_id);
        return e;
    }
    public void deleteEnrollment(Student student, int student_id, int course_id) throws SQLException {

        try {
            Statement statement = connection.createStatement();

            String sqlQuery = "DELETE FROM enrollments WHERE student_id_fk_pk = " + student_id + "and course_id_fk_pk = "+course_id;

            statement.executeUpdate(sqlQuery);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
