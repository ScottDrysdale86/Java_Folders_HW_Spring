package com.codeclan.examples.folders.repositories;

import com.codeclan.examples.folders.models.Folder;
import com.codeclan.examples.folders.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<Folder, Long> {
}
