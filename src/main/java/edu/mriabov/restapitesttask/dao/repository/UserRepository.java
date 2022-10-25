package edu.mriabov.restapitesttask.dao.repository;


import edu.mriabov.restapitesttask.dao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.Past;
import java.util.Date;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    void deleteByEmail(String email);

    List<User> getByBirthDateBetween(@Past Date startFrom, @Past Date endsAt);

}
