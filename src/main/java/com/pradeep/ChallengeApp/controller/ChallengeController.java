package com.pradeep.ChallengeApp.controller;

import com.pradeep.ChallengeApp.model.Challenge;
import com.pradeep.ChallengeApp.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChallengeController {

    private ChallengeService challengeService;

    @Autowired
    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping("/challenges")
    public ResponseEntity<List<Challenge>> getChallenges(){
        List<Challenge> list = challengeService.getAllChallenges();
        if(list!= null){
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/challenges")
    public ResponseEntity<String> createChallenge(@RequestBody Challenge challenge){
        boolean res = challengeService.createChallenge(challenge);
        if(res){
            return new ResponseEntity<>("Created successfully", HttpStatus.CREATED );
        }

        return new ResponseEntity<>("Failed to CREATE a new Resource", HttpStatus.NOT_IMPLEMENTED );
    }

    @GetMapping("/challenges/{month}")
    public ResponseEntity<Challenge> getSingleChallenge(@PathVariable String month){
        Challenge challenge = challengeService.getSingleChallenge(month);
        if(challenge != null){
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/challenges/{month}")
    public ResponseEntity<String> updateChallenge(@PathVariable String month, @RequestBody Challenge newChallenge){
        boolean challenge = challengeService.updateChallenge(month, newChallenge);

        if(challenge){
            return new ResponseEntity<>("Updated in challenges", HttpStatus.OK);
        }

        return new ResponseEntity<>("No Update has been done", HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("/challenges/{month}")
    public ResponseEntity<String> deleteChallenge(@PathVariable String month){

        boolean challenge = challengeService.deleteChallenge(month);

        if(challenge){
            return new ResponseEntity<>("Challenge is deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("No Delete has been done", HttpStatus.NOT_MODIFIED);
    }

}
