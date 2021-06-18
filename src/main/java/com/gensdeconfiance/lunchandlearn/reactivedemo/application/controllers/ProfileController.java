package com.gensdeconfiance.lunchandlearn.reactivedemo.application.controllers;

import com.gensdeconfiance.lunchandlearn.reactivedemo.domain.Profile;
import com.gensdeconfiance.lunchandlearn.reactivedemo.domain.ProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController("/profiles")
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    public List<Profile> getProfiles() {
        return profileService.getAll();
    }

    @GetMapping
    public Flux<Profile> getReactiveProfiles() {
        return profileService.getReactiveAll();
    }

}
