package edu.mriabov.restapitesttask.controller;

import edu.mriabov.restapitesttask.dao.daoservice.UserService;
import edu.mriabov.restapitesttask.dao.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final UserService userService;

    @PutMapping("/register")
    public HttpStatus registerUser(@Valid @RequestBody User user) {
        return userService.save(user) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
    }

    @GetMapping("/getUser")
    public ResponseEntity<List<User>> getUser(@RequestParam Date startFrom, @RequestParam Date endsAt) {
        if (startFrom.before(endsAt)) return ResponseEntity.badRequest().build();
        List<User> users = userService.getByBirthdays(startFrom, endsAt);
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/deleteUser")
    public HttpStatus deleteUser(@RequestParam String email) {
        userService.delete(email);
        return HttpStatus.OK;
    }

    @PutMapping("/editUser")
    public HttpStatus editUser(@RequestBody User user) {
        if (!userService.editUser(user)) return HttpStatus.NOT_FOUND;
        return HttpStatus.OK;
    }

}

