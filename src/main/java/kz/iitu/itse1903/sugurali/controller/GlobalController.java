package kz.iitu.itse1903.sugurali.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class GlobalController {

    @GetMapping("/login")
    public String getLoginView() {
        return "login";
    }

    @GetMapping("/profile")
    public String getprofileView() {
        return "profile";
    }

    @GetMapping("/book")
    public String getBookView() {
        return "book";
    }

    @GetMapping("/book/saveBook")
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public String getsaveBookView() {
        return "saveBook";
    }

    @RequestMapping("/book/findBook")
    public String getFindBookView() {
        return "findBook";
    }

    @RequestMapping("/book/findBookByTitle")
    public String getFindBookByTitleView() {
        return "findBookByTitle";
    }

    @RequestMapping("/book/findBookByAuthor")
    public String getFindBookByAuthorView() {
        return "findBookByAuthor";
    }

    @RequestMapping("/book/findBookByGenre")
    public String getFindBookByGenreView() {
        return "findBookByGenre";
    }

    @RequestMapping("/book/rentBook")
    public String getRentBookView() {
        return "rentBook";
    }

}