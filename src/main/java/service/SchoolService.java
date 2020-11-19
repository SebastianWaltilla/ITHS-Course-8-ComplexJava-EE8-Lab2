package service;

import entity.Student;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SchoolService {

    @PersistenceContext
    EntityManager entityManager;

    /*
    ● En student ska kunna ha flera ämnen.
    select * from student
    inner join subject
    where FIRSTNAME = 'Leo'
     */
    public  List<Student> getStudentAndHisSubjectByFirstName(String name) {

        return entityManager.createQuery("SELECT su.category, st.firstName FROM Subject su inner join Student st  WHERE st.firstName = \'"
                + name +"\'", Student.class).getResultList();
    }

    /*
    ● En lärare ska kunna ha ett ämne och ett antal elever
    ● Samma lärare ska kunna ha ett annat ämne och ett antal (andra) elever.
    SELECT  CATEGORY, FIRSTNAME FROM SUBJECT
    INNER JOIN TEACHER
    INNER JOIN STUDENT
    WHERE TEACHERNAME = 'Johan Svensson'  AND CATEGORY = 'Java'
     */
    public List<Student> getSubjectAndCourseByteacher(String subject, String teacherName) {

        return entityManager.createQuery("SELECT su.category, st.firstName FROM Subject su INNER JOIN Teacher te INNER JOIN Student st WHERE te.teacherName = \'"
                + teacherName + "\' AND su.category = \'" + subject + "\'", Student.class).getResultList();
    }
}
