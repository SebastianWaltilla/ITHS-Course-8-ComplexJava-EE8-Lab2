package rest;

import entity.PlayerData;
import service.PlayerService;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("item")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PlayerRest {

    @Inject
    PlayerService playerService;

    @Path("postPlayer")
    @POST
    public Response createPlayer(PlayerData player) {
        playerService.createStudent(player);
        return Response.ok(player).build();
    }

    @Path("getAllPlayers")
    @GET
    public Response getAllPlayers() {
        List<PlayerData> hej = playerService.getAllPlayers();
        return Response.ok(hej).build();
    }

    @Path("getPlayerById/{id}")
    @GET
    public Response getPlayerById(@PathParam("id") Long id){

        return Response.ok(playerService.findPlayerById(id)).build();

    }





}
