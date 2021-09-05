package pl.bartlomiejstepien.voteus.auth;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserCredential extends UserDetails
{
    Long getId();

    String getUsername();

    String getPassword();

    Long getVoteusUserId();
}
