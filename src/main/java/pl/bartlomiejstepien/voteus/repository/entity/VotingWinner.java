package pl.bartlomiejstepien.voteus.repository.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "voting_winner")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class VotingWinner
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "voting_id")
    private Voting voting;

    @OneToOne(optional = false)
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
}
