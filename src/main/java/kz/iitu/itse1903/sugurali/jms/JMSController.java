package kz.iitu.itse1903.sugurali.jms;

import kz.iitu.itse1903.sugurali.entity.book.Book;
import kz.iitu.itse1903.sugurali.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jms.JMSException;
import java.util.Random;

@RestController
@RequestMapping("/jms")
public class JMSController {
    @Autowired
    private MessageSender messageSender;

    @Autowired
    private MessageReceiver messageReceiver;

    @Autowired
    private BookService bookService;

    @PostMapping("/sendMessage")
    public String sendMessage() throws JMSException {
        Random random = new Random();
        int randomID = random.nextInt(5) + 1;
        Book book = bookService.findBookById(randomID);
        System.out.println("Selected bookID: " + randomID);

        messageSender.sendMessage(book.getTitle());
        return "Message: " + book.getTitle() + ", successfully sent";
    }

    @GetMapping("/getMessage")
    public String getMessage() throws JMSException {
        String message = messageReceiver.receiveMeassage();
        return "Received message: " + message;
    }
}