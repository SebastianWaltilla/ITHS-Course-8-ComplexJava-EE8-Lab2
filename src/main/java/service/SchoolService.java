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


    public  List<Student> getStudentAndHisSubjectByFirstName(String name) {

        List<Student> hej = entityManager.createQuery("SELECT su.category, st.firstName FROM Subject su inner join Student st  WHERE st.firstName = \'"+ name +"\'", Student.class).getResultList();


        //List<Student> hej = entityManager.createQuery("SELECT s FROM Student s inner join Subject  WHERE s.firstName = \'"+ name +"\'", Student.class).getResultList();

        System.out.println(hej.toString());
        return hej;
    }

    // get subject by studnet
    //get subject where student.name


    /*

    select * from student
    inner join subject
    where FIRSTNAME = 'Leo'


     */


    //● En lärare ska kunna ha ett ämne och ett antal elever
    //Get student by subject.name and teacher.name

    // ● Samma lärare ska kunna ha ett annat ämne och ett antal (andra) elever.
    // get teacher show subjects and student sort by subject


}
