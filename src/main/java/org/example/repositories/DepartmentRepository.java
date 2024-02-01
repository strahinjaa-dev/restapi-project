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

    public void deleteDepartment(Department department) throws SQLException {

        Configuration con= new Configuration().configure().addAnnotatedClass(Department.class);

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();

        session.beginTransaction();

        session.delete(department);

        session.getTransaction().commit();

    }

    public Department updateDepartment(Department department) {
        Configuration con= new Configuration().configure().addAnnotatedClass(Department.class);

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();

        session.beginTransaction();

        session.update(department);

        session.getTransaction().commit();

        return department;
    }

    public Department addDepartment(Department department) {

        Configuration con= new Configuration().configure().addAnnotatedClass(Department.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        session.save(department);

        tx.commit();

        return department;
    }

    public List<Department> getDepartments() throws SQLException {

        Configuration con= new Configuration().configure().addAnnotatedClass(Department.class);

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();

        session.beginTransaction();

        Criteria criteria= session.createCriteria(Department.class);
        List departments = criteria.list();
        session.getTransaction().commit();

        return departments;
    }
}
