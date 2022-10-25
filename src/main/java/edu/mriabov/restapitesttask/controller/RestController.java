package edu.mriabov.restapitesttask.controller;

import edu.mriabov.restapitesttask.config.Config;
import edu.mriabov.restapitesttask.dao.daoservice.UserService;
import edu.mriabov.restapitesttask.dao.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Instant;
import java.time.Year;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final UserService userService;
    private final Config config;

    @PutMapping("/register")
    public HttpStatus registerUser(@Valid @RequestBody User user) {
        if (user.getBirthDate().toInstant().isAfter(Instant.from(Year.now().minusYears(config.getAge())))){
            return HttpStatus.BAD_REQUEST;
        }
        userService.save(user);
        return HttpStatus.OK;
    }

    @GetMapping("/getUser")
    public ResponseEntity<List<User>> getUser(@RequestParam Date startFrom,@RequestParam Date endsAt){
        if (startFrom.before(endsAt)) return ResponseEntity.badRequest().build();
        List<User> users = userService.getByBirthdates(startFrom, endsAt);
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/deleteUser")
    public HttpStatus deleteUser(@RequestParam String email){
        userService.delete(email);
        return HttpStatus.OK;
    }
}
