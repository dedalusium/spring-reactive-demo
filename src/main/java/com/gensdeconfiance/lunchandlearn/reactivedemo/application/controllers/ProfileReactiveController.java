package com.gensdeconfiance.lunchandlearn.reactivedemo.application.controllers;

import com.gensdeconfiance.lunchandlearn.reactivedemo.domain.Profile;
import com.gensdeconfiance.lunchandlearn.reactivedemo.domain.ProfileService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/reactive")
public class ProfileReactiveController {
    private final ProfileService profileService;

    public ProfileReactiveController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/profiles")
    public Flux<Profile> getReactiveProfiles() {
        return profileService.getReactiveAll();
    }

    @GetMapping("/profiles/{profileId}")
    public Mono<Profile> getProfiles(@PathVariable String profileId, @RequestParam(required = false) Integer number) {
        return profileService.getReactiveProfile(profileId);
    }
}
