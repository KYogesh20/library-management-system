package com.spring2.librarymanagementsystem.Entity;

import com.spring2.librarymanagementsystem.Enum.CardStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
// helpfull to make clean code
@NoArgsConstructor // will add default constructor by default
@AllArgsConstructor // will add the all args constructor by default
@Getter
@Setter
public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardNo;

    private String validTill;

    private CardStatus status;

    @OneToOne
    @JoinColumn
    Student student;
}
