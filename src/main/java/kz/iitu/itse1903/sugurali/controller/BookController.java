package kz.iitu.itse1903.sugurali.controller;


import kz.iitu.itse1903.sugurali.entity.book.Book;
import kz.iitu.itse1903.sugurali.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    String username = "aba";

    @GetMapping("/showAllBooks")
    @ResponseStatus(HttpStatus.OK)
    public String showAllBooks(){
        List<Book> books = bookService.findAll();
        String result = "";

        for (Book book: books) {
            result += book.toString() + "<br>";
        }

        return result;
    }

    @GetMapping("/showPublishedBookByMe")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('USER')")
    public String showPublishedBookByMe(){
        List<Book> books = bookService.findAll();
        String result = "";

        for (Book book: books) {
            if(book.getOwner().equals(username) && book.getRented_owner() == null) {
                result += book.toString() + "<br>";
            }
        }

        return result;
    }

    @GetMapping("/showMyBooksThatExchanged")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('USER')")
    public String showMyBooksThatExchanged(){
        List<Book> books = bookService.findAll();
        String result = "";

        for (Book book: books) {
            if(book.getOwner().equals(username) && book.getRented_owner() != null) {
                result += book.toString() + "<br>";
            }
        }

        return result;
    }

    @GetMapping("/showBooksThatIRanted")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('USER')")
    public String showBooksThatIRanted(){
        List<Book> books = bookService.findAll();
        String result = "";

        for (Book book: books) {
            if(Objects.equals(book.getRented_owner(), username)) {
                result += book.toString() + "<br>";
            }
        }

        return result;
    }

    @PostMapping("/findBook/bookAvailability")
    public String bookAvailability1(@RequestParam int id, Model model) {
        Book book;
        book = bookService.findBookById(id);

        if (book == null) {
            return "book not found :(";
        }

        model.addAttribute("book", book);
        return "Book found :)<br>" + book.toString();
    }

    @PostMapping("/findBookByTitle/bookAvailability")
    public String bookAvailability2(@RequestParam String title, Model model) {
        return bookService.findBookByTitle(title, model);
    }

    @PostMapping("/findBookByAuthor/bookAvailability")
    public String bookAvailability3(@RequestParam String author, Model model) {
        return bookService.findBookByAuthor(author, model);
    }

    @PostMapping("/findBookByGenre/bookAvailability")
    public String bookAvailability4(@RequestParam String genre, Model model) {
        return bookService.findBookByGenre(genre, model);
    }

    @PostMapping ("/saveBook/saveBook2")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('USER')")
    public String saveBook(@RequestParam String title, @RequestParam String author,
                           @RequestParam String genre, @RequestParam String owner){

        Book book = new Book(title, author, genre, owner);

        System.out.println(book.toString());
        bookService.saveBook(book);
        return "Successfully saved!";
    }


    @PostMapping("/rentBook/rentBook2")
    @PreAuthorize("hasAnyRole('USER')")
    public String rentBook(@RequestParam int id, @RequestParam String rented_owner, Model model) {
        Book book;
        book = bookService.findBookById(id);

        if (book == null) {
            return "sorry, the book not found :(";
        }
        if (book.getRented_owner() != null && !book.getRented_owner().equals(username)) {
            return "sorry, the book has already been rented from other users :(";
        }
        if (Objects.equals(book.getRented_owner(), username)) {
            return "sorry, this book is already rented by you, please check your RentedBookList `:)";
        }

        book.setRented_owner(rented_owner);

        book = bookService.updateBook(book);

        model.addAttribute("book", book);
        return "Book successfully rented :)<br>" + book.toString();
    }

}
