package com.spring2.librarymanagementsystem.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring2.librarymanagementsystem.Enum.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
// helpful to make clean code
@NoArgsConstructor // will add default constructor by default
@AllArgsConstructor // will add the all args constructor by default
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private String title;

    private int price;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Author author;
}
