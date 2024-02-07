package org.example.repositories;

import org.example.jdbc.DatabaseConnection;
import org.example.models.Course;
import org.example.models.Department;
import org.example.models.Instructor;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository {

    Connection connection = DatabaseConnection.getConnection();

    public void deleteCourse(Course course) {

        Configuration con = new Configuration().configure().addAnnotatedClass(Course.class);
        SessionFactory sf = con.buildSessionFactory();


        Session session = sf.openSession();
        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();

            session.delete(course);

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

    public Course updateCourse(Course course) {

        Configuration con = new Configuration().configure().addAnnotatedClass(Course.class);
        SessionFactory sf = con.buildSessionFactory();


        Session session = sf.openSession();
        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();

            session.update(course);

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
        return course;
    }

    public Course addCourse(Course course) {

        Configuration con = new Configuration().configure().addAnnotatedClass(Course.class);
        SessionFactory sf = con.buildSessionFactory();


        Session session = sf.openSession();
        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();

            session.save(course);

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
        return course;
    }

    public List<Course> getCourses()  {

            Configuration con = new Configuration().configure().addAnnotatedClass(Course.class);
            SessionFactory sf = con.buildSessionFactory();


            Session session = sf.openSession();
            Transaction transaction = null;
            List<Course> courses = null;

            try {

                transaction = session.beginTransaction();

                Criteria criteria= session.createCriteria(Course.class);
                 courses = criteria.list();

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
        return courses;
    }
}