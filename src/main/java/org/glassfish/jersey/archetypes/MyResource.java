package org.glassfish.jersey.archetypes;

import com.topjavatutorial.dao.Employee;
import com.topjavatutorial.dao.EmployeeDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getEmployee() {
        EmployeeDAO dao = new EmployeeDAO();
        List employees = dao.getEmployees();
        return employees;
    }
/*
    @GET
    @Path("/get")
    @Produces(MediaType.TEXT_PLAIN)
    public String getEmployee() {
        EmployeeDAO dao = new EmployeeDAO();
        List employees = dao.getEmployees();
        return employees.toString();
    }
    */

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEmployee(Employee emp) {
        EmployeeDAO dao = new EmployeeDAO();
        dao.addEmployee(emp);
        return Response.ok().build();
    }

    @PUT
    @Path("/update/{id}")
    @Consumes("application/json")
    public Response updateEmployee(@PathParam("id") int id, Employee emp) {
        EmployeeDAO dao = new EmployeeDAO();
        int count = dao.updateEmployee(id, emp);
        if (count == 0) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Consumes("application/json")
    public Response deleteEmployee(@PathParam("id") int id) {
        EmployeeDAO dao = new EmployeeDAO();
        int count = dao.deleteEmployee(id);
        if (count == 0) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }

    //http://localhost:8080/webapi/myresource/get
}
