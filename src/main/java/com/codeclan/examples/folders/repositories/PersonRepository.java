package com.codeclan.examples.folders.repositories;

import com.codeclan.examples.folders.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
