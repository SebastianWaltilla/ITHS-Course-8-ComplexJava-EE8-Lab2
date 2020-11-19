package rest;

import entity.Student;
import exceptions.StudentNotFoundException;
import service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("school")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SchoolRest {



    @Inject
    StudentService studentService;



    @Path("getAllStudents")
    @GET
    public Response getAllPlayers() {
        List<Student> students = studentService.getAllStudents();
        if(students.isEmpty()){
            throw new StudentNotFoundException("No players in database");
        } else {
            return Response.ok(students).build();
        }
    }

}
