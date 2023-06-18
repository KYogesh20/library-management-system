package com.spring2.librarymanagementsystem.Controller;

import com.spring2.librarymanagementsystem.Entity.Author;
import com.spring2.librarymanagementsystem.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;
    @PostMapping("/add")
    public String addAuthor(@RequestBody Author author){
        authorService.addAuthor(author);
        return "author has been created";
    }

    @PostMapping("/get_authors")
    public List<Author> getAuthors(){
        return authorService.getAuthors();
    }

}
