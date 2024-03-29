package org.example.service;

import org.example.jdbc.DatabaseConnection;
import org.example.models.Department;
import org.example.repositories.DepartmentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentService {

    DepartmentRepository departmentRepository= new DepartmentRepository();

    public void deleteDepartment(Department department) {

        departmentRepository.deleteDepartment(department);
    }

    public Department updateDepartment(Department department) {

        return departmentRepository.updateDepartment(department);
    }

    public Department addDepartment(Department department) {

           return departmentRepository.addDepartment(department);
    }

    public List<Department> getDepartments() {

        return departmentRepository.getDepartments();
    }
}
