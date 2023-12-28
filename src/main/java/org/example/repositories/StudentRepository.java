package org.example.repositories;

import org.example.jdbc.DatabaseConnection;
import org.example.models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    Connection connection = DatabaseConnection.getConnection();

    public Student addStudent(Student student){

        try  {

            // SQL upit za unos podataka
            String insertQuery = "INSERT INTO students (first_name, last_name, instructor_id_fk) VALUES ( ?, ?, ? )";

            // Parametri koje ćete umetnuti
            String first_name = student.getFirst_name();
            String last_name = student.getLast_name();
            Integer id = student.getStudent_id();
            Integer instructor_id = student.getInstructor_id();

            // Priprema SQL naredbe s parametrima
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                //preparedStatement.setInt(1, id);
                preparedStatement.setString(1, first_name);
                preparedStatement.setString(2, last_name);
                preparedStatement.setInt(3, instructor_id);

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
        return student;
    }

    public List<Student> getAllStudents() throws SQLException{

        List<Student> students = new ArrayList<>();
        try {

            Statement statement = connection.createStatement();
            // Execute the query
            String query = "select * from students";
            ResultSet resultSet = statement.executeQuery(query);

            // Process the result set
            while (resultSet.next()) {
                int studentID = resultSet.getInt("student_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int instructorID = resultSet.getInt("instructor_id_fk");
                Student s = new Student(studentID, firstName, lastName, instructorID);

                students.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
    public void deleteStudentByID(Student student, int id) throws SQLException {
        try {
            Statement statement = connection.createStatement();
            String sqlQuery = "DELETE FROM students WHERE student_id = " + id;
            statement.executeUpdate(sqlQuery);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Student updateStudent(Student student){
        try {
            Statement statement = connection.createStatement();

            Integer id = student.getStudent_id();
            String first_name = student.getFirst_name();
            String last_name = student.getLast_name();
            Integer instructor_id= student.getInstructor_id();

            String sqlQuery = "UPDATE students SET first_name = ?, last_name = ?, instructor_id_fk = ? WHERE student_id = "+id;

            // Priprema PreparedStatement objekta
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                // Postavljanje vrednosti parametara
                preparedStatement.setString(1, first_name);
                preparedStatement.setString(2, last_name);
                preparedStatement.setInt(3, instructor_id);

                // Izvršite SQL upit
                int affectedRows = preparedStatement.executeUpdate();
                System.out.println("Broj ažuriranih redova: " + affectedRows);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
}
