package com.pradeep.ChallengeApp.service;

import com.pradeep.ChallengeApp.model.Challenge;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChallengeService {

    public List<Challenge> getAllChallenges();

    public boolean createChallenge(Challenge challenge);

}
