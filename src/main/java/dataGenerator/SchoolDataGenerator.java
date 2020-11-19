package dataGenerator;

import entity.Student;
import entity.Subject;
import entity.Teacher;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class SchoolDataGenerator {

    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct
    public void generateData() {

        Student student1 = new Student("Anton", "Månpuss", "Anton@Månpuss.nu", "031-010101");
        Student student2 = new Student( "Leo", "Lejon", "Leo@Lejon.nu", "0708-222333");
        Student student3 = new Student("Mia", "Uhh", "mia@Think.me", "031-223311");
        Student student4 = new Student("Li", "Fei", "Li@Fei.me", "0322-776655");

        Subject subject1 = new Subject("Java");
        Subject subject2 = new Subject("PHP");
        Subject subject3 = new Subject("Javascript");

        Teacher teacher1 = new Teacher("JohanSvensson");
        Teacher teacher2 = new Teacher("KicksJansson");
        Teacher teacher3 = new Teacher("OlleStrömberg");

        // fyll med refferenser

        student1.addSubject(subject1);
        student1.addSubject(subject2);
        student1.addSubject(subject3);
        student2.addSubject(subject1);
        student2.addSubject(subject2);
        student3.addSubject(subject3);

        student4.addSubject(subject3);

        teacher1.addSubject(subject1);
        teacher2.addSubject(subject2);

        // Send to entityManager
        entityManager.persist(student1);
        entityManager.persist(student2);
        entityManager.persist(student3);
        entityManager.persist(student4);
        entityManager.persist(teacher1);
        entityManager.persist(teacher2);
        entityManager.persist(teacher3);

    }
}
