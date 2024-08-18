package com.pradeep.ChallengeApp.serviceImp;

import com.pradeep.ChallengeApp.model.Challenge;
import com.pradeep.ChallengeApp.repo.ChallengeRepo;
import com.pradeep.ChallengeApp.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeServImp implements ChallengeService {

    private ChallengeRepo challengeRepo;

    @Autowired
    public ChallengeServImp(ChallengeRepo challengeRepo) {
        this.challengeRepo = challengeRepo;
    }

    public List<Challenge> getAllChallenges(){
        return challengeRepo.findAll();
    }

    @Override
    public boolean createChallenge(Challenge challenge) {

        challengeRepo.save(challenge);
        return true;
    }


}
