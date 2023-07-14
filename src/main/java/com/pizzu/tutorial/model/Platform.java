package com.pizzu.tutorial.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "platform")
@Data
@NoArgsConstructor
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "tutorial_platform",
            joinColumns = @JoinColumn(name = "id_platform"),
            inverseJoinColumns = @JoinColumn(name = "id_tutorial")
    )
    Set<Tutorial> tutorials;

}
