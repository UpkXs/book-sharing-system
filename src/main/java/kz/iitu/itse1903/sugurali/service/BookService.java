package kz.iitu.itse1903.sugurali.service;


import kz.iitu.itse1903.sugurali.entity.book.Book;
import kz.iitu.itse1903.sugurali.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> findAll() {
        List<Book> books = bookRepository.getAllBooks();

        return books;
    }

    public Book findBookById(int id) {
        Book book = bookRepository.getBookById(id);

        return book;
    }

    public String findBookByTitle(String title, Model model) {
        Book book;
        book = bookRepository.getBookByTitle(title);

        if (book == null) {
            return "book not found :(";
        }

        model.addAttribute("book", book);
        return "Book found :)<br>" + book.toString();
    }

    public String findBookByAuthor(String author, Model model) {
        Book book;
        book = bookRepository.getBookByAuthor(author);

        if (book == null) {
            return "book not found :(";
        }

        model.addAttribute("book", book);
        return "Book found :)<br>" + book.toString();
    }

    public String findBookByGenre(String genre, Model model) {
        Book book;
        book = bookRepository.getBookByGenre(genre);

        if (book == null) {
            return "book not found :(";
        }

        model.addAttribute("book", book);
        return "Book found :)<br>" + book.toString();
    }

    public void saveBook(Book book) {
        bookRepository.saveBook(book);
    }

    public Book updateBook(Book book) {
        return bookRepository.updateBook(book);
    }

    public void deleteBook(int id) {
        bookRepository.deleteBook(id);
    }


}
