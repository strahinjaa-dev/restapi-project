package org.example.swagger;

import org.example.models.Department;
import org.example.service.DepartmentService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.MediaType;
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

            departmentService.deleteDepartment(department);
    }
}
