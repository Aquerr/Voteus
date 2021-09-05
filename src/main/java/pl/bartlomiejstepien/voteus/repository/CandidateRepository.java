package pl.bartlomiejstepien.voteus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bartlomiejstepien.voteus.repository.entity.Candidate;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Long>
{
    List<Candidate> findAllByVotingId(Long votingId);
}
