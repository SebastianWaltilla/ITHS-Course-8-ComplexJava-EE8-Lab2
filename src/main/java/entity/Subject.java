package entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

// select * from buyer innerjoin
@Entity
public class Subject {

    // ITEM
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String category;

    @ManyToMany(mappedBy = "subjects", cascade = CascadeType.PERSIST)
    private Set<Student> students = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;


    // konstruktor utan ID -----------------
    public Subject(String category) {
        this.category = category;
    }

    public Subject() {
    }

// Getter/Setter

    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }

    // Anton säger att detta skall bort D:
    public Set<Student> getStudents() {
        return students;
    }










    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }



    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

}
