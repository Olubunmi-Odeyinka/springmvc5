package rss.springframework.spring5webapp.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {


    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String isbn;
    private String publisher;

    @ManyToMany
    @JoinTable(name="author_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name="author_id"))
    private Set<Author> authors = new HashSet<>();

    public Book(){}

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    public Book(String title, String isbn, String publicher) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publicher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublicher() {
        return publisher;
    }

    public void setPublicher(String publicher) {
        this.publisher = publicher;
    }


}
