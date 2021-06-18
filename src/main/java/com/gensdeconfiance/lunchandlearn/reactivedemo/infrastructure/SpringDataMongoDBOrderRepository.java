package com.gensdeconfiance.lunchandlearn.reactivedemo.infrastructure;

import com.gensdeconfiance.lunchandlearn.reactivedemo.domain.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataMongoDBOrderRepository extends MongoRepository<Profile, String> {
}
