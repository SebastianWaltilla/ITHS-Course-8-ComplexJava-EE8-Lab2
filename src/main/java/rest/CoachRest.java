package rest;

import entity.Coach;
import exceptions.PlayerNotFoundException;
import service.CoachService;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("Coach")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CoachRest {

    @Inject
    CoachService coachService;

    @Path("postCoach")
    @POST
    public Response createCoach(Coach coach) {
        coachService.createCoach(coach);
        return Response.ok(coach).build();
    }

    @Path("getAllGames")
    @GET
    public Response getAllGames() {
        List<Coach> game = coachService.getAllGames();
        if(game.isEmpty()){
            throw new PlayerNotFoundException("No players in database");
        } else {
            return Response.ok(game).build();
        }
    }

    @Path("updateGame")
    @PUT
    public Response updateGame(Coach coach) {
        if(coach != null)  {
            return Response.ok(coachService.updateGame(coach)).build();
        } else{
            throw new PlayerNotFoundException("Something wrong with your json formated game! ");
        }
    }

    @Path("deleteGame/{id}")
    @DELETE
    public Response deleteItem(@PathParam("id") Long id) {
        Coach aPlayer = coachService.findGameById(id);
        if (aPlayer != null){
            coachService.deleteGame(id);
            return Response.ok(aPlayer)
                    .entity("Player with ID " + id + " deleted.")
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .build();
        }else  {
            return Response.noContent().build();
        }
    }
}
