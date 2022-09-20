package com.codeclan.examples.folders.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="folders")
public class Folder {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @Column
    private String title;
    @ManyToOne
    @JoinColumn(name = "person", nullable = false)
    Person person;
    @OneToMany(mappedBy = "folder")
    @JsonIgnoreProperties({"folder"})
    private List<File> files;

    public Folder() {}

    public Folder(String title, Person person) {
        this.title = title;
        this.person = person;
        this.files = new ArrayList<>();

    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public void addFile(File file){
        this.files.add(file);
    }
}

