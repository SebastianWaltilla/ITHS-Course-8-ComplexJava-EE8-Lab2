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
    select * from student
    inner join subject
    where FIRSTNAME = 'Leo'
     */
    public  List<Student> getStudentAndHisSubjectByFirstName(String name) {

        return entityManager.createQuery("SELECT su.category, st.firstName FROM Subject su inner join Student st  WHERE st.firstName = \'"+ name +"\'", Student.class).getResultList();

    }

    //● En lärare ska kunna ha ett ämne och ett antal elever
    //Get student by subject.name and teacher.name

    // ● Samma lärare ska kunna ha ett annat ämne och ett antal (andra) elever.
    // get teacher show subjects and student sort by subject

    /*
    SELECT  CATEGORY, FIRSTNAME FROM SUBJECT
    INNER JOIN TEACHER
    INNER JOIN STUDENT
    WHERE TEACHERNAME = 'Johan Svensson'  AND CATEGORY = 'Java'
     */

    public List<Student> getSubjectAndCourseByteacher(String subject, String teacherName) {

        return entityManager.createQuery("SELECT su.category, st.firstName FROM Subject su   INNER JOIN Teacher te   INNER JOIN Student st   WHERE te.teacherName = 'Johan Svensson'  AND su.category = 'Java'", Student.class).getResultList();

    }





}
