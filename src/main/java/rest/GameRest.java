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
        List<Game> game = gameService.getAllGames();
       if(game.isEmpty()){
           throw new PlayerNotFoundException("No players in database");
       } else {
           return Response.ok(game).build();
       }
    }

    @Path("updateGame")
    @PUT
    public Response updateGame(Game game) {
        if(game != null)  {
            return Response.ok(gameService.updateGame(game)).build();
        } else{
            throw new PlayerNotFoundException("Something wrong with your json formated game! ");
        }
    }

    @Path("deleteGame/{id}")
    @DELETE
    public Response deleteItem(@PathParam("id") Long id) {
        Game aPlayer = gameService.findGameById(id);
        if (aPlayer != null){
            gameService.deleteGame(id);
            return Response.ok(aPlayer)
                    .entity("Player with ID " + id + " deleted.")
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .build();
        }else  {
            return Response.noContent().build();
        }
    }

}
