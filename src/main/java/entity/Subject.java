package entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String category;

    @ManyToMany(mappedBy = "subjects", cascade = CascadeType.PERSIST)
    private Set<Student> students = new HashSet<>();

    //@JoinColumn(name = "student_id")

    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacher;

    //@JoinColumn(name = "teacher_id")


    public Subject() {
    }

    public Subject(String category) {
        this.category = category;
    }

    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }

    // Maby delete this later?
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
