package pl.bartlomiejstepien.voteus.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class VotingDto
{
    private Long id;
    private String name;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private List<CandidateDto> candidateDtos;
}
