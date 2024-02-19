package com.backend.hackathon.hackathon_grup6.security.configuration;


import com.backend.hackathon.hackathon_grup6.domain.UserSecurity;
import com.backend.hackathon.hackathon_grup6.persistance.UserSecurityRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService implements UserDetailsService {
    private final UserSecurityRepository userSecurityRepository;

    public UserSecurityService(UserSecurityRepository userSecurityRepository) {
        this.userSecurityRepository = userSecurityRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("userman: " + username);
        UserSecurity user = userSecurityRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        System.out.println("user is: " + user.getUsername());
        return UserSecurityConfig.build(user);
    }

}