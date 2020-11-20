package service;

import entity.Student;
import entity.Subject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Transactional
public class SchoolService {

    @PersistenceContext
    EntityManager entityManager;

    //● En student ska kunna ha flera ämnen.
    public  List<Subject> getAllStudentBySubject(String name) {

        return entityManager
                .createQuery("SELECT s FROM Subject s WHERE s.category =\'" + name + "\'", Subject.class)
                .getResultList();
    }

    //● En lärare ska kunna ha ett ämne och ett antal elever
    //● Samma lärare ska kunna ha ett annat ämne och ett antal (andra) elever.

    public Set<Student> getStudentsBySubjectAndTeacher(String subjectName, String teacherName) {

       Subject subject = (Subject) entityManager
                .createQuery("SELECT DISTINCT i FROM Subject i INNER JOIN i.teacher t INNER JOIN i.students s WHERE t.teacherName = :teacherName AND i.category =:subjectName")
                .setParameter("teacherName", teacherName).setParameter("subjectName", subjectName).getSingleResult();
        Set<Student> studentsResult = subject.getStudents();
        return studentsResult;
    }

}
