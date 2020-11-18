package entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Subject {

    // ITEM
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String category;

    @ManyToMany
    private Student student;

    @ManyToOne
    private Teacher teacher;

    // Getter/Setter
}
