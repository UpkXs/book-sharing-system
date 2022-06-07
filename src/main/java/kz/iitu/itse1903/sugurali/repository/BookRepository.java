package kz.iitu.itse1903.sugurali.repository;

import kz.iitu.itse1903.sugurali.entity.book.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookRepository {
    private final JdbcTemplate jdbcTemplate;

    public Book saveBook(Book book) {
        jdbcTemplate.update("INSERT INTO book(title, author, genre, owner) VALUES(?,?,?,?)",
                book.getTitle(), book.getAuthor(), book.getGenre(), book.getOwner());
        return book;
    }

    public Book updateBook(Book book) {
        jdbcTemplate.update("UPDATE book SET rented_owner=? WHERE id=?",
                book.getRented_owner(), book.getId());
        return book;
    }

    public Book getBookById(int id) {
        return jdbcTemplate.query("Select * From book Where id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }

    public Book getBookByTitle(String title) {
        return jdbcTemplate.query("Select * From book Where title=?", new Object[]{title},
                new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }

    public Book getBookByAuthor(String author) {
        return jdbcTemplate.query("Select * From book Where author=?", new Object[]{author},
                new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }

    public Book getBookByGenre(String genre) {
        return jdbcTemplate.query("Select * From book Where genre=?", new Object[]{genre},
                new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }

    public List<Book> getAllBooks() {
        return jdbcTemplate.query("Select * From book", new BeanPropertyRowMapper<>(Book.class));
    }

    public int deleteBook(int id) {
        return jdbcTemplate.update("DELETE FROM book WHERE id=?", id);
    }
}
