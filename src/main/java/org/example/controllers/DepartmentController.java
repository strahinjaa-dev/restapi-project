package org.example.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.models.Department;
import org.example.service.DepartmentService;
import java.sql.SQLException;
import java.util.List;

@Path("/departments")
public class DepartmentController {

    DepartmentService departmentService= new DepartmentService();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Department> getMessageDepartments() throws SQLException {


        try {
            return departmentService.getDepartments();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return departmentService.getDepartments();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Department addDepartment(Department department){
        return departmentService.addDepartment(department);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Department updateDepartment(Department department){

        return departmentService.updateDepartment(department);

    }
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteDepartment( Department department){


        try {
            departmentService.deleteDepartment(department);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
