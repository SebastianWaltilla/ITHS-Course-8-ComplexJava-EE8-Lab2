package entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String teacherName;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.PERSIST)
    private Set<Subject> subjects = new HashSet<>();

    public void addSubject(Subject subject) {
        subjects.add(subject);
        subject.setTeacher(this);
    }

    public Teacher(String teacherName) {
        this.teacherName = teacherName;
    }

    public Teacher() {
    }

    // Getters/Setters
    public String getName() {
        return teacherName;
    }

    public void setName(String name) {
        this.teacherName = name;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }
}
