package rest;

import entity.Student;
import service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("school")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SchoolRest {



    @Inject
    StudentService studentService;



    //--------------------- student REST
    @Path("postStudent")
    @POST
    public Response createStudent(Student player) {
        studentService.createStudent(player);
        return Response.ok(player).build();
    }

}
