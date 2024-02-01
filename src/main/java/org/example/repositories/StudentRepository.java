package org.example.repositories;

import org.example.jdbc.DatabaseConnection;
import org.example.models.Instructor;
import org.example.models.Student;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import javax.imageio.spi.ServiceRegistry;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    Connection connection = DatabaseConnection.getConnection();

    public Student addStudent(Student student){

        Student s= new Student();

        Configuration con= new Configuration().configure().addAnnotatedClass(Student.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        session.save(student);

        tx.commit();

        return student;
    }

    public List<Student> getAllStudents() throws SQLException{

        Configuration con= new Configuration().configure().addAnnotatedClass(Student.class);

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();

        session.beginTransaction();

        Criteria criteria= session.createCriteria(Student.class);
        List students = criteria.list();
        session.getTransaction().commit();

        return students;
    }
    public void deleteStudentByID(Student student) throws SQLException {
        int id = student.getStudent_id();

        Configuration con= new Configuration().configure().addAnnotatedClass(Student.class);

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();

        session.beginTransaction();

        session.delete(student);

        session.getTransaction().commit();

    }
    public Student updateStudent(Student student){

        Configuration con= new Configuration().configure().addAnnotatedClass(Student.class);

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();

        session.beginTransaction();

        session.update(student);

        session.getTransaction().commit();

        return student;
    }
}
