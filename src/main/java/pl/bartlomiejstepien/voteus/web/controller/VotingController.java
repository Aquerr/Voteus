package pl.bartlomiejstepien.voteus.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.bartlomiejstepien.voteus.service.CandidateService;
import pl.bartlomiejstepien.voteus.service.VotingService;

@Controller
@RequiredArgsConstructor
public class VotingController
{
    private final VotingService votingService;
    private final CandidateService candidateService;

    @GetMapping("/")
    public String index(Model model)
    {
        model.addAttribute("voting", votingService.getActiveVoting());
        return "index";
    }
}
