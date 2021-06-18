package com.gensdeconfiance.lunchandlearn.reactivedemo.infrastructure;

import com.gensdeconfiance.lunchandlearn.reactivedemo.domain.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpringDataMongoDBOrderRepository extends MongoRepository<Profile, String> {
}
