package edu.mriabov.restapitesttask.dao.repository;


import edu.mriabov.restapitesttask.dao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Past;
import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    void deleteByEmail(String email);

    List<User> getByBirthDateBetween(@Past Date startFrom, @Past Date endsAt);

}
