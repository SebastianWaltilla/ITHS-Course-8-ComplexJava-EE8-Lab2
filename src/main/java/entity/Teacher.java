package entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Teacher {

    // teacher has multiple subjects

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String name;

    @OneToMany
    @JoinColumn(name = "teacher_subject")
    private Subject subject;

    // Getters/Setters


}
