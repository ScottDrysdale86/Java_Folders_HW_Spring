package com.codeclan.examples.folders.components;


import com.codeclan.examples.folders.models.File;
import com.codeclan.examples.folders.models.Folder;
import com.codeclan.examples.folders.models.Person;
import com.codeclan.examples.folders.repositories.FileRepository;
import com.codeclan.examples.folders.repositories.FolderRepository;
import com.codeclan.examples.folders.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class DataLoader implements ApplicationRunner {

    public DataLoader() {}

    @Autowired
    PersonRepository personRepo;

    @Autowired
    FolderRepository folderRepo;

    @Autowired
    FileRepository fileRepo;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Person scott = new Person("Scott" );
        Folder work = new Folder("Work Stuff", scott);
        File word = new File("CV", "doc", 12,work);
        scott.addFolder(work);
        work.addFile(word);

        personRepo.save(scott);
        folderRepo.save(work);
        fileRepo.save(word);

        Person paul = new Person("Paul" );
        Folder music = new Folder("Tunes", paul);
        Folder videos = new Folder("Vids", paul);
        File song1 = new File("Baby Shark", "mp3", 12,music);
        File song2 = new File("Paw Patrol", "mp3", 10,music);

        paul.addFolder(music);
        paul.addFolder(videos);
        music.addFile(song1);
        music.addFile(song2);

        personRepo.save(paul);
        folderRepo.save(music);
        folderRepo.save(videos);
        fileRepo.save(song1);
        fileRepo.save(song2);






    }
}
