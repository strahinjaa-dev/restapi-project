package org.example.repositories;

import org.example.jdbc.DatabaseConnection;
import org.example.models.Instructor;
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
    public void deleteInstructor(Instructor instructor) {

        Configuration con = new Configuration().configure().addAnnotatedClass(Instructor.class);
        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();
        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();

            session.delete(instructor);

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {

            if (session != null) {
                session.close();
            }
        }
    }

    public Instructor updateInstructor(Instructor instructor) {

        Configuration con = new Configuration().configure().addAnnotatedClass(Instructor.class);
        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();
        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();

            session.update(instructor);

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {

            if (session != null) {
                session.close();
            }
        }
        return instructor;
    }

    public Instructor addInstructor(Instructor instructor) {

        Configuration con = new Configuration().configure().addAnnotatedClass(Instructor.class);
        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();
        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();

            session.save(instructor);

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {

            if (session != null) {
                session.close();
            }
        }
        return instructor;
    }

    public List<Instructor> getInstructors() {

        Configuration con = new Configuration().configure().addAnnotatedClass(Instructor.class);
        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();
        Transaction transaction = null;
        List<Instructor> instructors = null;

        try {

            transaction = session.beginTransaction();

            Criteria criteria= session.createCriteria(Instructor.class);
            instructors = criteria.list();

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {

            if (session != null) {
                session.close();
            }
        }
        return instructors;
    }
}
