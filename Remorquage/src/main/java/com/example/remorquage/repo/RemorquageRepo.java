package com.example.remorquage.repo;

import com.example.remorquage.entity.Remorquage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemorquageRepo extends MongoRepository<Remorquage, String> {
}

