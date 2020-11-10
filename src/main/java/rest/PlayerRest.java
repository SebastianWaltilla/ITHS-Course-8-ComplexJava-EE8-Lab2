package rest;

import entity.PlayerData;
import service.PlayerService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("item")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PlayerRest {


    @Inject
    PlayerService playerService;

    @Path("new")
    @POST
    public Response createPlayer(PlayerData player) {
        playerService.createStudent(player);
        return Response.ok(player).build();
    }
}
