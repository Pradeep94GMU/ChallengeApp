package com.pradeep.ChallengeApp.controller;

import com.pradeep.ChallengeApp.model.Challenge;
import com.pradeep.ChallengeApp.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChallengeController {

    private ChallengeService challengeService;

    @Autowired
    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping("/challenges")
    public List<Challenge> getChallenges(){
        return challengeService.getAllChallenges();
    }

    @PostMapping("/challenges")
    public String createChallenge(@RequestBody Challenge challenge){
        boolean res = challengeService.createChallenge(challenge);
        if(res){
            return "Created successfully";
        }

        return "Failed to create";
    }

}
