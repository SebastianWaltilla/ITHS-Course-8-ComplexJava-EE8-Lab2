package service;
import entity.PlayerData;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class PlayerService {

    @PersistenceContext
    EntityManager entityManager;

    public PlayerData createStudent(PlayerData player) {
        entityManager.persist(player);
        return player;
    }

    public PlayerData updateTodo(PlayerData player) {
        entityManager.merge(player);
        return player;
    }

    public PlayerData findStudentById(Long id) {
        return entityManager.find(PlayerData.class, id);
    }

    public List<PlayerData> getAllStudents() {
        return entityManager.createQuery("SELECT s from PlayerData s", PlayerData.class).getResultList();
    }


}
