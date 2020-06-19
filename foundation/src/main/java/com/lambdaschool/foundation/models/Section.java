package com.lambdaschool.foundation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "sections")
public class Section extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sectionid;

    private String sectionname;

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("section")
    private List<Book> booksInSection = new ArrayList<>();

    public Section() {
    }

    public Section(String sectionname, List<Book> booksInSection) {
        this.sectionname = sectionname;
        this.booksInSection = booksInSection;
    }

    public Section(String sectionname) {
        this.sectionname = sectionname;
    }

    public long getSectionid() {
        return sectionid;
    }

    public void setSectionid(long sectionid) {
        this.sectionid = sectionid;
    }

    public String getSectionname() {
        return sectionname;
    }

    public void setSectionname(String sectionname) {
        this.sectionname = sectionname;
    }

    public List<Book> getBooksInSection() {
        return booksInSection;
    }

    public void setBooksInSection(List<Book> booksInSection) {
        this.booksInSection = booksInSection;
    }
}