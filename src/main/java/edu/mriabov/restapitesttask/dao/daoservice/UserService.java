package edu.mriabov.restapitesttask.dao.daoservice;

import edu.mriabov.restapitesttask.dao.model.User;
import edu.mriabov.restapitesttask.dao.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public void delete(String email){
        userRepository.deleteByEmail(email);
    }

    public List<User> getByBirthdates(Date startFrom, Date endsAt){
        return userRepository.getByBirthDateBetween(startFrom, endsAt);
    }
}
