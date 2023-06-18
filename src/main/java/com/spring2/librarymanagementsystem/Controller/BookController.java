package com.spring2.librarymanagementsystem.Controller;

import com.spring2.librarymanagementsystem.Entity.Book;
import com.spring2.librarymanagementsystem.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public String addBook(@RequestBody Book book){
        try{
            bookService.addBook(book);
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage() + "book not added");
        }

        return "book added successfully";
    }

    @GetMapping("get-books")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

}
