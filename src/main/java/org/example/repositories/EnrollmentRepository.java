package org.example.repositories;

import org.example.jdbc.DatabaseConnection;
import org.example.models.Course;
import org.example.models.Department;
import org.example.models.Enrollment;
import org.example.models.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentRepository {

    Connection connection = DatabaseConnection.getConnection();

    public List<Enrollment> getEnrollments() throws SQLException {


        Configuration con= new Configuration().configure().addAnnotatedClass(Enrollment.class);

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();

        session.beginTransaction();

        Criteria criteria= session.createCriteria(Enrollment.class);
        List enrollments = criteria.list();
        session.getTransaction().commit();

        return enrollments;
    }
    public Enrollment addEnrollment(Enrollment enrollment){

        Configuration con= new Configuration().configure().addAnnotatedClass(Enrollment.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        session.save(enrollment);

        tx.commit();

        return enrollment;
    }
    public void deleteEnrollment(Enrollment enrollment) throws SQLException {

        Configuration con= new Configuration().configure().addAnnotatedClass(Enrollment.class);

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();

        session.beginTransaction();

        session.delete(enrollment);

        session.getTransaction().commit();
    }
}
