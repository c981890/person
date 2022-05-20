package com.moderansolutions.person.repository;

import com.moderansolutions.person.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
    List<Person> findByNameContainingIgnoreCase(@Param("name") String name);
}
