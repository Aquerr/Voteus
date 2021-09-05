package pl.bartlomiejstepien.voteus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bartlomiejstepien.voteus.repository.entity.VoteusUser;

public interface VotuesUserRepository extends JpaRepository<VoteusUser, Long>
{

}
