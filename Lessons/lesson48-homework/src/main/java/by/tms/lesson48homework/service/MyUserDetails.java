package by.tms.lesson48homework.service;

import by.tms.lesson48homework.dao.UserRepository;
import by.tms.lesson48homework.entity.AppUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyUserDetails implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<AppUser> optionalAppUser = userRepository.findByUsername(username);

        if (optionalAppUser.isEmpty()) {
            throw new UsernameNotFoundException("User '" + username + "' not found");
        }

        AppUser appUser = optionalAppUser.get();
        return User
                .withUsername(username)
                .password(appUser.getPassword())
                .authorities(appUser.getPassword())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
