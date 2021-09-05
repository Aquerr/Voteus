package pl.bartlomiejstepien.voteus.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bartlomiejstepien.voteus.dto.CandidateDto;
import pl.bartlomiejstepien.voteus.repository.entity.Candidate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CandidateConverter
{
    private final DepartmentConverter departmentConverter;

    public List<CandidateDto> convertToDtos(List<Candidate> candidates)
    {
        return Optional.ofNullable(candidates)
                .map(candidates1 -> candidates1.stream()
                        .map(this::convertToDto)
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }

    public CandidateDto convertToDto(Candidate candidate)
    {
        if (candidate == null)
            return null;

        CandidateDto candidateDto = new CandidateDto();
        candidateDto.setId(candidate.getId());
        candidateDto.setName(candidate.getName());
        candidateDto.setVotingId(candidate.getVotingId());
        candidateDto.setDepartmentDto(departmentConverter.convertToDto(candidate.getDepartment()));
        return candidateDto;
    }
}
