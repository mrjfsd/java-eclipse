package com.example.test4.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.test4.model.Tmodel;

public interface Trepository extends MongoRepository<Tmodel, Integer> {

}
