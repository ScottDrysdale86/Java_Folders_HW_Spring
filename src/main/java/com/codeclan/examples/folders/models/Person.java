package com.codeclan.examples.folders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="persons")
public class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;
    @Column
    private String name;

    @OneToMany(mappedBy = "person")
    @JsonIgnoreProperties({"person"})
    private List<Folder> folders;

    public Person() {}

    public Person(String name) {
        this.name = name;
        this.folders = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Folder> getFolders() {
        return folders;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }

    public void addFolder(Folder folder){
        this.folders.add(folder);
    }
}
