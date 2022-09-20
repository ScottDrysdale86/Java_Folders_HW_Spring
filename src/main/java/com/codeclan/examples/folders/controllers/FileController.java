package com.codeclan.examples.folders.controllers;

import com.codeclan.examples.folders.models.File;
import com.codeclan.examples.folders.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class FileController {



    @Autowired
    FileRepository fileRepo;

    @GetMapping(value="/files")
    public ResponseEntity<List<File>> getAllFiles(){
        return new ResponseEntity<>(fileRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/files/{id}")
    public ResponseEntity getFile(@PathVariable Long id){
        return new ResponseEntity(fileRepo.findById(id),HttpStatus.OK);
    }

    @PostMapping(value = "/files")
    public ResponseEntity<File> postFile(@RequestBody File file){
        fileRepo.save(file);
        return new ResponseEntity<>(file, HttpStatus.CREATED);
    }
}
