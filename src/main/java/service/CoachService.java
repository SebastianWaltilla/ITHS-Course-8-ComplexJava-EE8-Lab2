package service;
import entity.Coach;
import entity.Game;
import entity.PlayerData;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CoachService {


    @PersistenceContext
    EntityManager entityManager;

    public Coach createCoach(Coach coach) {
        entityManager.persist(coach);
        return coach;
    }

    public List<Coach> getAllGames() {
        return entityManager.createQuery("SELECT s from Coach s", Coach.class).getResultList();
    }

    public Coach findGameById(Long id) {
        return entityManager.find(Coach.class, id);
    }

    public Coach updateGame(Coach coach) {
        entityManager.merge(coach);
        return coach;
    }

    public Coach deleteGame(Long id) {
        Coach coach = entityManager.find(Coach.class, id);
        entityManager.remove(coach);
        return coach;
    }

}
