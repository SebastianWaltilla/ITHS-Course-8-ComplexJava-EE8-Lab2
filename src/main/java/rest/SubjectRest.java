package rest;

import entity.Subject;
import exceptions.StudentNotFoundException;
import service.SubjectService;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("subject")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SubjectRest {

    @Inject
    SubjectService subjectService;

    @Path("postSubject")
    @POST
    public Response createItem(Subject item) {
        subjectService.createSubject(item);
        return Response.ok(item).build();
    }

    @Path("getAllSubjects")
    @GET
    public Response getAllGames() {
        List<Subject> item = subjectService.getAllSubjects();
       if(item.isEmpty()){
           throw new StudentNotFoundException("No items in database");
       } else {
           return Response.ok(item).build();
       }
    }

    @Path("updateSubject")
    @PUT
    public Response updateGame(Subject item) {
        if(item != null)  {
            return Response.ok(subjectService.updateSubject(item)).build();
        } else{
            throw new StudentNotFoundException("Something wrong with your json formated game! ");
        }
    }

    @Path("deleteSubject/{id}")
    @DELETE
    public Response deleteItem(@PathParam("id") Long id) {
        Subject aPlayer = subjectService.findSubjectById(id);
        if (aPlayer != null){
            subjectService.deleteSubject(id);
            return Response.ok(aPlayer)
                    .entity("Subject with ID " + id + " deleted.")
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .build();
        }else  {
            return Response.noContent().build();
        }
    }

}
