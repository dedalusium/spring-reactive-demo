package com.gensdeconfiance.lunchandlearn.reactivedemo.infrastructure;

import com.gensdeconfiance.lunchandlearn.reactivedemo.domain.Profile;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface SpringDataMongoDBReactiveOrderRepository extends ReactiveCrudRepository<Profile, String> {
}
