package pl.bartlomiejstepien.voteus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bartlomiejstepien.voteus.repository.entity.VotingWinner;

public interface VotingWinnerRepository extends JpaRepository<VotingWinner, Long>
{

}