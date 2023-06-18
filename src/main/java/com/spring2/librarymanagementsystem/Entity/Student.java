package com.spring2.librarymanagementsystem.Entity;

import com.spring2.librarymanagementsystem.Enum.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
// helpfull to make clean code
@NoArgsConstructor // will add default constructor by default
@AllArgsConstructor // will add the all args constructor by default
@Getter
@Setter
public class Student {
    // id,name,age

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    // @Enumerated(EnumType.ORDINAL) if we use this then itll add the departments as indexes in the sql db
    @Enumerated(EnumType.STRING)
    private Department department;

    @Column(unique = true)
    private String email;

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL) // cascade will automatically create a library card as soon as any student takes admission
    LibraryCard card;


}
    