package com.kaczyn.springmongodbteste.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kaczyn.springmongodbteste.entity.CarDataEntity;

@Repository
public interface CarDataRepository extends MongoRepository<CarDataEntity, String> {

}
