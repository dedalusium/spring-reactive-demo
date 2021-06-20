package com.gensdeconfiance.lunchandlearn.reactivedemo.domain;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ProfileRepository {
    List<Profile> getAllProfiles();
    Flux<Profile> getReactiveAllProfiles();
    List<Profile> saveProfiles(List<Profile> profiles);
    Flux<Profile> saveReactiveProfiles(List<Profile> profiles);
    void deleteAll();
    Mono<Void> deleteReactiveAll();
    Profile getProfile(String id);
    Mono<Profile> getReactiveProfile(String profileId);
}
