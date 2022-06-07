package kz.iitu.itse1903.sugurali.entity.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = AUTO)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "genre")
    private String genre;
    @Column(name = "owner")
    private String owner;
    @Column(name = "rented_owner")
    private String rented_owner;

    public Book(String title, String author, String genre, String owner) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.owner = owner;
    }
}
