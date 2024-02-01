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

    public void deleteCourse(Course course) throws SQLException {

        Configuration con= new Configuration().configure().addAnnotatedClass(Course.class);

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();

        session.beginTransaction();

        session.delete(course);

        session.getTransaction().commit();
    }

    public Course updateCourse(Course course) {

        Configuration con= new Configuration().configure().addAnnotatedClass(Course.class);

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();

        session.beginTransaction();

        session.update(course);

        session.getTransaction().commit();

        return course;
    }

    public Course addCourse(Course course) {

        Configuration con= new Configuration().configure().addAnnotatedClass(Course.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        session.save(course);

        tx.commit();

        return course;
    }

    public List<Course> getCourses() throws SQLException {


        Configuration con= new Configuration().configure().addAnnotatedClass(Course.class);

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();

        session.beginTransaction();

        Criteria criteria= session.createCriteria(Course.class);
        List courses = criteria.list();
        session.getTransaction().commit();
        return courses;
    }
}
