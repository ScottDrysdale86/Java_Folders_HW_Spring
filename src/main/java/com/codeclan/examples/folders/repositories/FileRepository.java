package com.codeclan.examples.folders.repositories;

import com.codeclan.examples.folders.models.File;
import com.codeclan.examples.folders.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
