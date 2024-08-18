package com.pradeep.ChallengeApp.service;

import com.pradeep.ChallengeApp.model.Challenge;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChallengeService {

    public List<Challenge> getAllChallenges();

    public boolean createChallenge(Challenge challenge);

    public Challenge getSingleChallenge(String month);

    public boolean updateChallenge(String month, Challenge newChallenge);

    public boolean deleteChallenge(String month);

}
