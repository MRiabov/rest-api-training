package edu.mriabov.restapitesttask.dao.daoservice;

import edu.mriabov.restapitesttask.config.Config;
import edu.mriabov.restapitesttask.dao.model.User;
import edu.mriabov.restapitesttask.dao.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.Year;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final Config config;

    public boolean save(User user) {
        boolean isMature = user.getBirthDate().toInstant().isAfter(Instant.from(Year.now().minusYears(config.getAge())));
        if (isMature) userRepository.save(user);
        return isMature;
    }

    public void delete(String email){
        userRepository.deleteByEmail(email);
    }

    public List<User> getByBirthdays(Date startFrom, Date endsAt){
        return userRepository.getByBirthDateBetween(startFrom, endsAt);
    }

    public boolean editUser(User user) {
        if (!userRepository.existsById(user.getId())) return false;
        userRepository.save(user);
        return true;
    }
}
