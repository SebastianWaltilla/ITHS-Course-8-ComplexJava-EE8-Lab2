package entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Teacher {

    // teacher / Buyer has multiple subjects

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String teacher;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.PERSIST)
    private Set<Subject> subjects = new HashSet<>();

    public void addSubject(Subject subject) {
        subjects.add(subject);
        subject.setTeacher(this);
    }


    // konstruktor utan ID -------------------
    public Teacher(String teacherName) {
        this.teacher = teacherName;
    }

    public Teacher() {
    }

    // Getters/Setters


    public String getName() {
        return teacher;
    }

    public void setName(String name) {
        this.teacher = name;
    }


    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }
}
