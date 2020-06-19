package com.lambdaschool.foundation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "section")
public class Section extends Auditable {

    // sectionid
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sectionid;

    // sectionname
    @Column(nullable = false)
    private String name;



    @OneToMany(mappedBy = "section")
    @JsonIgnoreProperties("sections")
    private List<Book> book = new ArrayList<>();

    // Default Constructor
    public Section() {

    }

    // Constructor
    public Section(String name) {
        this.name = name;
    }

    public Section(String name, List<Book> book) {
        this.name = name;
        this.book = book;
    }

    // Getters and Setters
    public long getSectionid() {
        return sectionid;
    }

    public void setSectionid(long sectionid) {
        this.sectionid = sectionid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }

    // toString
    @Override
    public String toString() {
        return "Section{" +
                "sectionid=" + sectionid +
                ", name='" + name + '\'' +
                ", book=" + book +
                '}';
    }
}