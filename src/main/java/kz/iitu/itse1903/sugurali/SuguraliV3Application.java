package kz.iitu.itse1903.sugurali;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.jms.JMSException;
import javax.persistence.TransactionRequiredException;


@SpringBootApplication
@EnableJpaRepositories(basePackages = { "kz.iitu.itse1903.sugurali" })
@EntityScan(basePackages = { "kz.iitu.itse1903.sugurali" })
public class SuguraliV3Application implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(SuguraliV3Application.class);

    public static void main(String[] args) throws JMSException {
        SpringApplication.run(SuguraliV3Application.class, args);
    }

    @Override
    public void run(String... args) throws TransactionRequiredException {
        System.out.println("The project has been successfully launched `:)");
    }
}







