package com.gensdeconfiance.lunchandlearn.reactivedemo.application.controllers;

import com.gensdeconfiance.lunchandlearn.reactivedemo.domain.Profile;
import com.gensdeconfiance.lunchandlearn.reactivedemo.domain.ProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    public List<Profile> getProfiles() {
        return profileService.getAll();
    }

    @GetMapping("/{profileId}")
    public Profile getProfiles(@PathVariable String profileId, @RequestParam(required = false) Integer number) {
        return profileService.getProfile(profileId);
    }
}
