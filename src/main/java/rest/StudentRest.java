package rest;

import entity.Student;
import exceptions.StudentNotFoundException;
import service.StudentService;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("student")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentRest {

    // http://localhost:8080/PlayerDataEEDemo/h2

    @Inject
    StudentService studentService;

    @Path("postStudent")
    @POST
    public Response createStudent(Student player) {
        studentService.createStudent(player);
        return Response.ok(player).build();
    }

    @Path("getAllStudents")
    @GET
    public Response getAllPlayers() {
        List<Student> player = studentService.getAllStudents();
       if(player.isEmpty()){
           throw new StudentNotFoundException("No players in database");
       } else {
           return Response.ok(player).build();
       }
    }

    @Path("getStudentById/{id}")
    @GET
    public Response getPlayerById(@PathParam("id") Long id){
        Student player = studentService.findStudentById(id);
        if (player != null) {
            return Response.ok(player).build();
        } else {
            throw new StudentNotFoundException("Player with ID " + id + " not found.");
        }
    }

    @Path("updateStudent")
    @PUT
    public Response updatePlayer(Student player) {
        if(player != null)  {
            return Response.ok(studentService.updateStudent(player)).build();
        } else{
            throw new StudentNotFoundException("Something wrong with your json formated player! ");
        }
    }

    @Path("deleteStudent/{id}")
    @DELETE
    public Response deleteItem(@PathParam("id") Long id) {
        Student aPlayer = studentService.findStudentById(id);
        if (aPlayer != null){
            studentService.deleteStudent(id);
            return Response.ok(aPlayer)
                    .entity("Player with ID " + id + " deleted.")
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .build();
        }else  {
            return Response.noContent().build();
        }
    }

    @Path("getStudentByLastName/{name}")
    @GET
    public Response getByLastName(@PathParam("name") String name) {
        List<Student> hej = studentService.getByLastName(name);
        if(hej.size() == 0){
            return Response.noContent().build();
        } else{
            return Response.ok(hej).build();
        }
    }



}
