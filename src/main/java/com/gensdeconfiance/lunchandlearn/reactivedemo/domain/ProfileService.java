package com.gensdeconfiance.lunchandlearn.reactivedemo.domain;

import reactor.core.publisher.Flux;

import java.util.List;

public class ProfileService {
    private final ProfileRepository repository;

    public ProfileService(ProfileRepository repository) {
        this.repository = repository;
    }

    public List<Profile> getAll() {
        return repository.getAllProfiles();
    }

    public Flux<Profile> getReactiveAll() {
        return repository.getReactiveAllProfiles();
    }
}
