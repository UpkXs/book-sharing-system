package kz.iitu.itse1903.sugurali.aspect;

import kz.iitu.itse1903.sugurali.entity.book.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(20)
public class Logging {

    @Before("kz.iitu.itse1903.sugurali.aspect.Pointcuts.findAllBooks()")
    public void beforeFindAllBooksAdvice(){
        System.out.println("Before: Attempt to get data about the books...");
    }

    @Before("kz.iitu.itse1903.sugurali.aspect.Pointcuts.saveBook()")
    public void beforeSaveBookAdvice(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        if (methodSignature.getName().equals("saveBook")){
            Object[] arguments = joinPoint.getArgs();

            for (Object object: arguments){
                if (object instanceof Book){
                    Book book = (Book) object;
                    System.out.println("Before method saveBook(): " + book.toString());
                }
            }
        }
    }

    @After("kz.iitu.itse1903.sugurali.aspect.Pointcuts.findAllBooks()")
    public void afterFindAllBooksAdvice(){
        System.out.println("After: The operation was successfully completed!");
    }

    @AfterReturning("kz.iitu.itse1903.sugurali.aspect.Pointcuts.findAllBooks()")
    public void afterReturningFindAllBooksAdvice(){
        System.out.println("AfterReturning: The operation was successfully completed!");
    }

}
