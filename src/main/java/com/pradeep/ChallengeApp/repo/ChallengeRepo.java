package com.pradeep.ChallengeApp.repo;

import com.pradeep.ChallengeApp.model.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeRepo extends JpaRepository<Challenge, Integer> {
}
