package pl.bartlomiejstepien.voteus.converter;

import org.springframework.stereotype.Service;
import pl.bartlomiejstepien.voteus.dto.CandidateDto;
import pl.bartlomiejstepien.voteus.dto.VotingDto;
import pl.bartlomiejstepien.voteus.repository.entity.Voting;

import java.util.List;

@Service
public class VotingConverter
{
    public VotingDto convertToDto(Voting voting, List<CandidateDto> candidatesDtos)
    {
        if (voting == null)
            return null;
        VotingDto votingDto = new VotingDto();
        votingDto.setId(voting.getId());
        votingDto.setName(voting.getName());
        votingDto.setStartDateTime(voting.getStartDateTime());
        votingDto.setEndDateTime(voting.getEndDateTime());
        votingDto.setCandidateDtos(candidatesDtos);
        return votingDto;
    }

    public Voting convertToEntity(VotingDto votingDto)
    {
        if (votingDto == null)
            return null;
        Voting voting = new Voting();
        voting.setId(votingDto.getId());
        voting.setName(votingDto.getName());
        voting.setStartDateTime(votingDto.getStartDateTime());
        voting.setEndDateTime(votingDto.getEndDateTime());
        return voting;
    }
}
