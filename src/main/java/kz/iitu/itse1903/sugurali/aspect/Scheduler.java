package kz.iitu.itse1903.sugurali.aspect;

import kz.iitu.itse1903.sugurali.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Scheduler {
    @Autowired
    BookService bookService;

    Format f = new SimpleDateFormat("hh:mm:ss");

    @Scheduled(cron = "${scheduled.cron-expression}")   //At every 20th second
    void getToralCountOfBooks() {
        System.out.println("The total count of books: " + bookService.findAll() +
                ", Time: " + f.format(new Date()));
    }

}
