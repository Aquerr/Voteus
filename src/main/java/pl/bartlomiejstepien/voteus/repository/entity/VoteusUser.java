package pl.bartlomiejstepien.voteus.repository.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "voteus_user")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class VoteusUser
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Enumerated(value = EnumType.ORDINAL)
    @OneToOne(optional = false)
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
