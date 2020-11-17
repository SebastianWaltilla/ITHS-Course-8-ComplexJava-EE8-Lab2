package service;

import entity.Game;
import entity.PlayerData;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class GameService {


    @PersistenceContext
    EntityManager entityManager;

    public Game createGame(Game game) {
        entityManager.persist(game);
        return game;
    }

    public List<Game> getAllGames() {
        return entityManager.createQuery("SELECT s from Game s", Game.class).getResultList();
    }

    public PlayerData findPlayerById(Long id) {
        return entityManager.find(PlayerData.class, id);
    }

    public PlayerData updatePlayer(PlayerData player){

        entityManager.merge(player);
        return player;
    }


    public PlayerData deletePlayer(Long id){
        PlayerData player = entityManager.find(PlayerData.class, id);
        entityManager.remove(player);
        return player;
    }


    public List<PlayerData> getByLastName(String name) {
        return entityManager.createQuery("SELECT e FROM PlayerData e WHERE e.lastname = \'"+ name +"\'", PlayerData.class).getResultList();

    }


}
