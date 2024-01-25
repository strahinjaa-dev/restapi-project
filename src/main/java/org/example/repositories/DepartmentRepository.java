package org.example.repositories;

import org.example.jdbc.DatabaseConnection;
import org.example.models.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository {

    Connection connection = DatabaseConnection.getConnection();

    public void deleteDepartment(Department department) throws SQLException {

        int id= department.getDepartment_id();
        try {
            Statement statement = connection.createStatement();

            String sqlQuery = "DELETE FROM departments WHERE department_id = " + id;

            statement.executeUpdate(sqlQuery);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Department updateDepartment(Department department) {

        try {
            Statement statement = connection.createStatement();

            Integer id = department.getDepartment_id();
            String name = department.getDepartment_name();


            String sqlQuery = "UPDATE departments SET department_name = ? WHERE department_id = " + id;

            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {

                preparedStatement.setString(1, name);


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
        return department;
    }

    public Department addDepartment(Department department) {

        try {

            String insertQuery = "INSERT INTO departments ( department_name ) VALUES ( ? )";

            String name = department.getDepartment_name();


            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, name);


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
        return department;
    }

    public List<Department> getDepartments() throws SQLException {

        List<Department> departments = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();

            String query = "select * from departments";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int department_id = resultSet.getInt("department_id");
                String department_name = resultSet.getString("department_name");

                Department d = new Department(department_id, department_name);

                departments.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departments;
    }
}
