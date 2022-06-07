package kz.iitu.itse1903.sugurali.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    @Pointcut("execution(* kz.iitu.itse1903.sugurali.service.BookService.findAll())")
    public void findAllBooks(){}

    @Pointcut("execution(* kz.iitu.itse1903.sugurali.service.BookService.findBookById(..))")
    public void findBookById(){}

    @Pointcut("execution(* kz.iitu.itse1903.sugurali.service.BookService.saveBook())")
    public void saveBook(){}

}
