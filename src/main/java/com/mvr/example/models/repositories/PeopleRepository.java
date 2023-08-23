package com.mvr.example.models.repositories;

import com.mvr.example.models.Person;
import com.redis.om.spring.repository.RedisDocumentRepository;

public interface PeopleRepository extends RedisDocumentRepository<Person,String> {
    
}
