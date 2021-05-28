package com.example.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AthleteRepository extends CrudRepository<Department, Integer> {
    
}
