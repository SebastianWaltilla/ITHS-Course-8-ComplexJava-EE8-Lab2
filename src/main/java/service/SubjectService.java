package service;

import entity.Subject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class SubjectService {

    @PersistenceContext
    EntityManager entityManager;

    public Subject createSubject(Subject subject) {
        entityManager.persist(subject);
        return subject;
    }

    public List<Subject> getAllSubjects() {
        return entityManager.createQuery("SELECT s from Subject s", Subject.class).getResultList();
    }

    public Subject findSubjectById(Long id) {
        return entityManager.find(Subject.class, id);
    }

    public Subject updateSubject(Subject subject) {
        entityManager.merge(subject);
        return subject;
    }

    public Subject deleteSubject(Long id) {
        Subject subject = entityManager.find(Subject.class, id);
        entityManager.remove(subject);
        return subject;
    }
}
