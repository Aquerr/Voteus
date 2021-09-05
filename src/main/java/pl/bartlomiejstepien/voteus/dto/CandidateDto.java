package pl.bartlomiejstepien.voteus.dto;

import lombok.Data;

@Data
public class CandidateDto
{
    private Long id;
    private String name;
    private String description;
    private Long votingId;
    private DepartmentDto departmentDto;
}
