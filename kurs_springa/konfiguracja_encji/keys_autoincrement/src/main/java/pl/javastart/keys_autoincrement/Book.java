package pl.javastart.keys_autoincrement;

import jakarta.persistence.*;

@Entity
class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private int pageNumber;
    @Column(name = "release_year")
    private int year;

    public Book(){};

    public Book(String title, String author, String publisher, int publishYear, int pageNumber) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = publishYear;
        this.pageNumber = pageNumber;
    }
}


