package rest;

import entity.Game;
import entity.PlayerData;
import exceptions.PlayerNotFoundException;
import service.GameService;
import service.PlayerService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("Game")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GameRest {

    // http://localhost:8080/PlayerDataEEDemo/h2

    @Inject
    GameService gameService;

    @Path("postGame")
    @POST
    public Response createGame(Game game) {
        gameService.createGame(game);
        return Response.ok(game).build();
    }

    @Path("getAllGames")
    @GET
    public Response getAllGames() {
        List<PlayerData> player = playerService.getAllPlayers();
       if(player.isEmpty()){
           throw new PlayerNotFoundException("No players in database");
       } else {
           return Response.ok(player).build();
       }
    }

}
