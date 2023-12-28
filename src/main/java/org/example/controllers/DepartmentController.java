package org.example.contollers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.models.Department;
import org.example.service.DepartmentService;
import java.sql.SQLException;
import java.util.List;

@Path("/message")
public class DepartmentController {

    DepartmentService departmentService= new DepartmentService();
    @GET
    @Path("/departments")
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
    @Path("/departments")
    @Consumes(MediaType.APPLICATION_JSON)
    public Department addDepartment(Department department){
        return departmentService.addDepartment(department);
    }

    @PUT
    @Path("/departments/{departmentid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Department updateDepartment(@PathParam("departmentid") int id, Department department){

        department.setDepartment_id(id);
        return departmentService.updateDepartment(department);

    }
    @DELETE
    @Path("/departments/{departmentid}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteDepartment(@PathParam("departmentid") int id, Department department){

        department.setDepartment_id(id);
        try {
            departmentService.deleteDepartment(department, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
