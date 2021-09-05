package pl.bartlomiejstepien.voteus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bartlomiejstepien.voteus.repository.entity.Voting;

import java.time.LocalDateTime;

public interface VotingRepository extends JpaRepository<Voting, Long>
{
    Voting findVotingByEndDateTimeAfter(LocalDateTime localDateTime);
}