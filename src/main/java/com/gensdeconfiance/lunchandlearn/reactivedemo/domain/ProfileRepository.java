package com.gensdeconfiance.lunchandlearn.reactivedemo.domain;

import reactor.core.publisher.Flux;

import java.util.List;

public interface ProfileRepository {
    List<Profile> getAllProfiles();
    Flux<Profile> getReactiveAllProfiles();
    Flux<Profile> saveProfiles(List<Profile> profiles);
}
