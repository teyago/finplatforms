package com.goncharov.finplatforms.secondTask.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String patronymic;

    @Column(name = "group_name")
    private String group;

    @Column
    private LocalDate birthday;
}
