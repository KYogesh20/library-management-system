package com.spring2.librarymanagementsystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.*;

@Entity
// helpful to make clean code
@NoArgsConstructor // will add default constructor by default
@AllArgsConstructor // will add the all args constructor by default
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private String name;

    private int age;

    private String mobNo;

    private String email;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    List<Book> books = new ArrayList<>(); // this will create a empty list of books whenever author is created

}
