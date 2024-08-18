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

    @Override
    public Challenge getSingleChallenge(String month) {

        List<Challenge> list = challengeRepo.findAll();

        for(Challenge challenge: list){
            if(challenge.getMonth().equalsIgnoreCase(month)){
                return challenge;
            }
        }

        return null;
    }

    @Override
    public boolean updateChallenge(String month, Challenge newChallenge) {

        List<Challenge> list = challengeRepo.findAll();

        for(Challenge challenge: list){
            if(challenge.getMonth().equalsIgnoreCase(month)){
                challenge.setName(newChallenge.getName());
                challenge.setMonth(newChallenge.getMonth());
                challenge.setDescription(newChallenge.getDescription());
                challengeRepo.save(challenge);
                System.out.println("Updated :"+challenge);
                return true;
            }
        }


        return false;
    }

    @Override
    public boolean deleteChallenge(String month) {

        List<Challenge> list = challengeRepo.findAll();

        for(Challenge challenge: list){
            if(challenge.getMonth().equalsIgnoreCase(month)){
                challengeRepo.delete(challenge);
                return true;
            }
        }
        return false;
    }


}
