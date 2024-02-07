package org.example.repositories;

import org.example.jdbc.DatabaseConnection;

import org.example.models.Enrollment;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.*;

import java.util.List;

public class EnrollmentRepository {

    Connection connection = DatabaseConnection.getConnection();

    public List<Enrollment> getEnrollments(){


        Configuration con = new Configuration().configure().addAnnotatedClass(Enrollment.class);
        SessionFactory sf = con.buildSessionFactory();


        Session session = sf.openSession();
        Transaction transaction = null;
        List<Enrollment> enrollments = null;

        try {

            transaction = session.beginTransaction();

            Criteria criteria= session.createCriteria(Enrollment.class);
            enrollments = criteria.list();

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
        return enrollments;
    }
    public Enrollment addEnrollment(Enrollment enrollment){

        Configuration con = new Configuration().configure().addAnnotatedClass(Enrollment.class);
        SessionFactory sf = con.buildSessionFactory();


        Session session = sf.openSession();
        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();

            session.save(enrollment);

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
        return enrollment;
    }
    public void deleteEnrollment(Enrollment enrollment)  {

        Configuration con = new Configuration().configure().addAnnotatedClass(Enrollment.class);
        SessionFactory sf = con.buildSessionFactory();


        Session session = sf.openSession();
        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();

            session.delete(enrollment);

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
}
