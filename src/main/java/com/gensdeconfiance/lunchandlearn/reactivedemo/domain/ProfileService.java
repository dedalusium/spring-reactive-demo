package com.gensdeconfiance.lunchandlearn.reactivedemo.domain;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
        return repository.getReactiveAllProfiles().map(p -> {
            var newP = new Profile();
            newP.setNumber(p.getNumber()*2);
            newP.setId(p.getId());
            return newP;
        });
    }

    public Profile getProfile(final String id) {
        return repository.getProfile(id);
    }

    public Mono<Profile> getReactiveProfile(String profileId) {
        return repository.getReactiveProfile(profileId);
    }
}
