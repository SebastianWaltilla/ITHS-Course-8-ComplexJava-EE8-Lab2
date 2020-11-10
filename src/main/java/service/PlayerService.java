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

    public List<PlayerData> getAllPlayers() {
        return entityManager.createQuery("SELECT s from PlayerData s", PlayerData.class).getResultList();
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



}
