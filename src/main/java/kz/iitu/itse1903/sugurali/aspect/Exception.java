package kz.iitu.itse1903.sugurali.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(10)
public class Exception {

    @AfterThrowing("kz.iitu.itse1903.sugurali.aspect.Pointcuts.saveBook()")
    public void afterThrowingSaveBookAdvice(){
        System.out.println("AfterThrowing: Caught an exception!" );
    }

}
