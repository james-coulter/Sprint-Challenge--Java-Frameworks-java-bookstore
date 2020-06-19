package com.lambdaschool.foundation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "book")
public class Book extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid;


    @Column(nullable = false)
    private String title;


    @Column(nullable = false,
            unique = true)
    private String isbn;


    private int copy;


    @OneToMany(mappedBy = "book",
            cascade = CascadeType.ALL)
    @JsonIgnoreProperties("book")
    private List<Wrote> wrote = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "sectionid")
    @JsonIgnoreProperties("books")
    private Section section;

    public Book()
    {
    }

    public Book(String title, String isbn, int copy, List<Wrote> wrote)
    {
        this.title = title;
        this.isbn = isbn;
        this.copy = copy;

        for (Wrote w : wrote)
        {
            w.setBook(this);
        }
        this.wrote = wrote;
    }

    public long getBookid()
    {
        return bookid;
    }

    public void setBookid(long bookid)
    {
        this.bookid = bookid;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }

    public int getCopy()
    {
        return copy;
    }

    public void setCopy(int copy)
    {
        this.copy = copy;
    }

    public List<Wrote> getWrote()
    {
        return wrote;
    }

    public void setWrote(List<Wrote> wrote)
    {
        this.wrote = wrote;
    }
}