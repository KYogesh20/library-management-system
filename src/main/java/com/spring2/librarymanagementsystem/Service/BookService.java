package com.spring2.librarymanagementsystem.Service;

import com.spring2.librarymanagementsystem.Entity.Author;
import com.spring2.librarymanagementsystem.Entity.Book;
import com.spring2.librarymanagementsystem.Repository.AuthorRepository;
import com.spring2.librarymanagementsystem.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    public void addBook(Book book) throws Exception {
        Author author;
        try{
            author = authorRepository.findById(book.getAuthor().getId()).get();
        }
        catch (Exception e){
            throw new Exception("Author not present");
        }

        List<Book> booksWritten = author.getBooks();
        booksWritten.add(book);
        authorRepository.save(author);
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }
}
