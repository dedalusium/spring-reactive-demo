package com.gensdeconfiance.lunchandlearn.reactivedemo.infrastructure;

import com.gensdeconfiance.lunchandlearn.reactivedemo.domain.ProfileService;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableMongoRepositories
@EnableReactiveMongoRepositories
public class MongoDBConfiguration {
    @Bean
    public ProfileService profileService(MongoDBProfileRepository repository){
        return new ProfileService(repository);
    }

    @Bean
    public MongoDBProfileRepository mongoDBProfileRepository(SpringDataMongoDBOrderRepository repository, SpringDataMongoDBReactiveOrderRepository reactiveRepository) {
        return new MongoDBProfileRepository(repository, reactiveRepository);
    }
}
