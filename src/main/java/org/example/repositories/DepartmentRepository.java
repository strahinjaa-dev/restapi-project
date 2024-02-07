package org.example.repositories;

import org.example.jdbc.DatabaseConnection;
import org.example.models.Course;
import org.example.models.Department;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository {

    Connection connection = DatabaseConnection.getConnection();

    public void deleteDepartment(Department department) {

        Configuration con = new Configuration().configure().addAnnotatedClass(Department.class);
        SessionFactory sf = con.buildSessionFactory();


        Session session = sf.openSession();
        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();

            session.delete(department);

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

    public Department updateDepartment(Department department) {

        Configuration con = new Configuration().configure().addAnnotatedClass(Department.class);
        SessionFactory sf = con.buildSessionFactory();


        Session session = sf.openSession();
        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();

            session.update(department);

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
        return department;
    }

    public Department addDepartment(Department department) {

        Configuration con = new Configuration().configure().addAnnotatedClass(Department.class);
        SessionFactory sf = con.buildSessionFactory();


        Session session = sf.openSession();
        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();

            session.save(department);

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
        return department;
    }

    public List<Department> getDepartments() {

        Configuration con = new Configuration().configure().addAnnotatedClass(Department.class);
        SessionFactory sf = con.buildSessionFactory();


        Session session = sf.openSession();
        Transaction transaction = null;
        List<Department> departments = null;

        try {

            transaction = session.beginTransaction();

            Criteria criteria= session.createCriteria(Department.class);
            departments = criteria.list();

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
        return departments;
    }
}
