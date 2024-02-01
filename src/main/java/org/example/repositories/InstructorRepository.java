package org.example.repositories;

import org.example.jdbc.DatabaseConnection;
import org.example.models.Instructor;
import org.example.models.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstructorRepository {

    Connection connection = DatabaseConnection.getConnection();
    public void deleteInstructor(Instructor instructor) throws SQLException {

        Configuration con= new Configuration().configure().addAnnotatedClass(Instructor.class);

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();

        session.beginTransaction();

        session.delete(instructor);

        session.getTransaction().commit();
    }

    public Instructor updateInstructor(Instructor instructor) {

        Configuration con= new Configuration().configure().addAnnotatedClass(Instructor.class);

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();

        session.beginTransaction();

        session.update(instructor);

        session.getTransaction().commit();

        return instructor;
    }

    public Instructor addInstructor(Instructor instructor) {

        Configuration con= new Configuration().configure().addAnnotatedClass(Instructor.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        session.save(instructor);

        tx.commit();

        return instructor;
    }

    public List<Instructor> getInstructors() throws SQLException {

        Configuration con= new Configuration().configure().addAnnotatedClass(Instructor.class);

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();

        session.beginTransaction();

        Criteria criteria= session.createCriteria(Instructor.class);
        List instructors = criteria.list();
        session.getTransaction().commit();

        return instructors;
    }
}
