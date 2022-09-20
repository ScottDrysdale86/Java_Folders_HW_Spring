package com.codeclan.examples.folders.controllers;

import com.codeclan.examples.folders.models.File;
import com.codeclan.examples.folders.models.Folder;
import com.codeclan.examples.folders.repositories.FileRepository;
import com.codeclan.examples.folders.repositories.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FolderController {

    @Autowired
    FolderRepository folderRepo;

    @GetMapping(value="/folders")
    public ResponseEntity<List<Folder>> getAllFolder(){
        return new ResponseEntity<>(folderRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/folders/{id}")
    public ResponseEntity getFolders(@PathVariable Long id){
        return new ResponseEntity(folderRepo.findById(id),HttpStatus.OK);
    }

    @PostMapping(value = "/folders")
    public ResponseEntity<Folder> postFolder(@RequestBody Folder folder){
        folderRepo.save(folder);
        return new ResponseEntity<>(folder, HttpStatus.CREATED);
    }
}
