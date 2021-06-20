package com.gensdeconfiance.lunchandlearn.reactivedemo.infrastructure;

import com.gensdeconfiance.lunchandlearn.reactivedemo.domain.Profile;
import com.gensdeconfiance.lunchandlearn.reactivedemo.domain.ProfileRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
    public List<Profile> saveProfiles(List<Profile> profiles) {
        return repository.saveAll(profiles);
    }

    @Override
    public Flux<Profile> saveReactiveProfiles(List<Profile> profiles) {
        return reactiveRepository.saveAll(profiles);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public Mono<Void> deleteReactiveAll() {
        return reactiveRepository.deleteAll();
    }

    @Override
    public Profile getProfile(String id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Mono<Profile> getReactiveProfile(String id) {
        return reactiveRepository.findById(id);
    }
}
