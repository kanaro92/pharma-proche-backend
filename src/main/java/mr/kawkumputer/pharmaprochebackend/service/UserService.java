package mr.kawkumputer.pharmaprochebackend.service;

import lombok.AllArgsConstructor;
import mr.kawkumputer.pharmaprochebackend.model.User;
import mr.kawkumputer.pharmaprochebackend.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        return this.userRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format("user with email %s not found", phoneNumber)));
    }

    public List<User> findAllUsers() {
        return this.userRepository.findAll();
    }
}
