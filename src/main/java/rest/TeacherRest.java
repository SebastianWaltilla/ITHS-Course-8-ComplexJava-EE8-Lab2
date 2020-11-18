package rest;

import entity.Teacher;
import exceptions.StudentNotFoundException;
import service.TeacherService;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("teacher")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeacherRest {

    @Inject
    TeacherService teacherService;

    @Path("postTeacher")
    @POST
    public Response createCoach(Teacher teacher) {
        teacherService.createTeacher(teacher);
        return Response.ok(teacher).build();
    }

    @Path("getAllTeachers")
    @GET
    public Response getAllGames() {
        List<Teacher> game = teacherService.getAllTeachers();
        if(game.isEmpty()){
            throw new StudentNotFoundException("No players in database");
        } else {
            return Response.ok(game).build();
        }
    }

    @Path("updateTeacher")
    @PUT
    public Response updateGame(Teacher teacher) {
        if(teacher != null)  {
            return Response.ok(teacherService.updateTeacher(teacher)).build();
        } else{
            throw new StudentNotFoundException("Something wrong with your json formated game! ");
        }
    }

    @Path("deleteTeacher/{id}")
    @DELETE
    public Response deleteTeacher(@PathParam("id") Long id) {
        Teacher aPlayer = teacherService.findGameById(id);
        if (aPlayer != null){
            teacherService.deleteTeacher(id);
            return Response.ok(aPlayer)
                    .entity("Player with ID " + id + " deleted.")
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .build();
        }else  {
            return Response.noContent().build();
        }
    }
}
