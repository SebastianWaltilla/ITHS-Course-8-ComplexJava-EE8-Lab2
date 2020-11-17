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

    public Game findGameById(Long id) {
        return entityManager.find(Game.class, id);
    }

    public Game updateGame(Game game) {
        entityManager.merge(game);
        return game;
    }

    public Game deleteGame(Long id) {
        Game game = entityManager.find(Game.class, id);
        entityManager.remove(game);
        return game;
    }
}
