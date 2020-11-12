package rest;

import entity.PlayerData;
import exceptions.PlayerNotFoundException;
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
        PlayerData foundMovie = playerService.findPlayerById(id);
        if (foundMovie != null) {
            return Response.ok(foundMovie).build();
        } else {
            throw new PlayerNotFoundException("Player with ID " + id + " not found.");
        }
    }

    @Path("updatePlayer")
    @PUT
    public Response updatePlayer(PlayerData player) {
            return Response.ok(playerService.updatePlayer(player)).build();
    }

    @Path("deletePlayer/{id}")
    @DELETE
    public Response deleteItem(@PathParam("id") Long id) {
        PlayerData aPlayer = playerService.findPlayerById(id);
        if (aPlayer != null){
            playerService.deletePlayer(id);
            return Response.ok(aPlayer)
                    .entity("Player with ID " + id + " deleted.")
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .build();
        }else  {
            return Response.noContent().build();
        }
    }

    @Path("getByLastName/{name}")
    @GET
    public Response getByLastName(@PathParam("name") String name) {
        List<PlayerData> hej = playerService.getByLastName(name);
        if(hej.size() == 0){
            return Response.noContent().build();
        } else{
            return Response.ok(hej).build();
        }
    }



}
