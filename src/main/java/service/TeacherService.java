package service;

import entity.Teacher;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class TeacherService {


    @PersistenceContext
    EntityManager entityManager;

    public Teacher createTeacher(Teacher teacher) {
        entityManager.persist(teacher);
        return teacher;
    }

    public List<Teacher> getAllTeachers() {
        return entityManager.createQuery("SELECT s from Teacher s", Teacher.class).getResultList();
    }

    public Teacher findGameById(Long id) {
        return entityManager.find(Teacher.class, id);
    }

    public Teacher updateTeacher(Teacher teacher) {
        entityManager.merge(teacher);
        return teacher;
    }

    public Teacher deleteTeacher(Long id) {
        Teacher teacher = entityManager.find(Teacher.class, id);
        entityManager.remove(teacher);
        return teacher;
    }

}
