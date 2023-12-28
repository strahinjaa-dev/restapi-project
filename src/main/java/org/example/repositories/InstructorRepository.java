package org.example.repositories;

import org.example.jdbc.DatabaseConnection;
import org.example.models.Instructor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstructorRepository {

    Connection connection = DatabaseConnection.getConnection();
    public void deleteInstructor(Instructor instructor, int id) throws SQLException {

        try {
            Statement statement = connection.createStatement();

            String sqlQuery = "DELETE FROM instructors WHERE employee_id = " + id;

            statement.executeUpdate(sqlQuery);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Instructor updateInstructor(Instructor instructor) {

        try {
            Statement statement = connection.createStatement();

            Integer id = instructor.getEmployee_id();
            String first_name = instructor.getFirst_name();
            String last_name = instructor.getLast_name();

            String sqlQuery = "UPDATE instructors SET first_name = ?, last_name = ? WHERE employee_id = " + id;

            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {

                preparedStatement.setString(1, first_name);
                preparedStatement.setString(2, last_name);

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
        return instructor;
    }

    public Instructor addInstructor(Instructor instructor) {

        try {

            String insertQuery = "INSERT INTO instructors ( first_name, last_name) VALUES ( ?, ?)";

            String name = instructor.getFirst_name();
            String last_name = instructor.getLast_name();
            Integer id = instructor.getEmployee_id();

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, last_name);
                //preparedStatement.setString(3, last_name);

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
        return instructor;
    }

    public List<Instructor> getInstructors() throws SQLException {

        List<Instructor> instructors = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();

            String query = "select * from instructors";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int employeeID = resultSet.getInt("employee_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                Instructor i = new Instructor(employeeID, firstName, lastName,-1);

                instructors.add(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instructors;
    }
}
