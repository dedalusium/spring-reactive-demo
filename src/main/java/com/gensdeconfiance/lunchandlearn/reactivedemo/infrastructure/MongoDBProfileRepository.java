package com.gensdeconfiance.lunchandlearn.reactivedemo.infrastructure;

import com.gensdeconfiance.lunchandlearn.reactivedemo.domain.Profile;
import com.gensdeconfiance.lunchandlearn.reactivedemo.domain.ProfileRepository;
import reactor.core.publisher.Flux;

import java.util.List;

public class MongoDBProfileRepository implements ProfileRepository {

    private final SpringDataMongoDBOrderRepository repository;
    private final SpringDataMongoDBReactiveOrderRepository reactiveRepository;

    public MongoDBProfileRepository(SpringDataMongoDBOrderRepository repository, SpringDataMongoDBReactiveOrderRepository reactiveRepository) {
        this.repository = repository;
        this.reactiveRepository = reactiveRepository;
    }

    @Override
    public List<Profile> getAllProfiles() {
        return repository.findAll();
    }

    @Override
    public Flux<Profile> getReactiveAllProfiles() {
        return reactiveRepository.findAll();
    }

    @Override
    public Flux<Profile> saveProfiles(List<Profile> profiles) {
        return reactiveRepository.saveAll(profiles);
    }
}
