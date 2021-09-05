package pl.bartlomiejstepien.voteus.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bartlomiejstepien.voteus.converter.CandidateConverter;
import pl.bartlomiejstepien.voteus.converter.VotingConverter;
import pl.bartlomiejstepien.voteus.dto.CandidateDto;
import pl.bartlomiejstepien.voteus.dto.DepartmentDto;
import pl.bartlomiejstepien.voteus.dto.VotingDto;
import pl.bartlomiejstepien.voteus.repository.CandidateRepository;
import pl.bartlomiejstepien.voteus.repository.VotingRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class VotingServiceImpl implements VotingService
{
    private final VotingRepository votingRepository;
    private final VotingConverter votingConverter;
    private final CandidateRepository candidateRepository;
    private final CandidateConverter candidateConverter;

    @Override
    @Transactional
    public VotingDto getActiveVoting()
    {
        VotingDto votingDto = Optional.ofNullable(votingRepository.findVotingByEndDateTimeAfter(LocalDateTime.now()))
                .map(voting -> votingConverter.convertToDto(voting, candidateConverter.convertToDtos(candidateRepository.findAllByVotingId(voting.getId()))))
                .orElse(null);

        votingDto = new VotingDto();
        votingDto.setId(1L);
        votingDto.setName("Głosowanie na mistrza IT 2021");
        votingDto.setStartDateTime(LocalDateTime.now());
        votingDto.setEndDateTime(LocalDateTime.now().plus(3, ChronoUnit.MONTHS));
        votingDto.setCandidateDtos(generateCandidates());

        return votingDto;
    }

    private List<CandidateDto> generateCandidates()
    {
        List<CandidateDto> candidateDtos = new LinkedList<>();
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(1L);
        departmentDto.setName("BRI");
        CandidateDto candidateDto = new CandidateDto();
        candidateDto.setId(1L);
        candidateDto.setName("Wojtek Górski");
        candidateDto.setVotingId(1L);
        candidateDto.setDescription("Wojtek jest pro elo hardkorowym programistą!");
        candidateDto.setDepartmentDto(departmentDto);
        CandidateDto candidateDto2 = new CandidateDto();
        candidateDto2.setId(2L);
        candidateDto2.setName("Monika Wojtyła");
        candidateDto2.setVotingId(1L);
        candidateDto2.setDescription("Monika jest naszą zajebistą testerką!");
        candidateDto2.setDepartmentDto(departmentDto);
        candidateDtos.add(candidateDto);
        candidateDtos.add(candidateDto2);
        return candidateDtos;
    }
}
