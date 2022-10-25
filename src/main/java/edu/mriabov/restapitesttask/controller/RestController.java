package edu.mriabov.restapitesttask.controller;

import edu.mriabov.restapitesttask.dao.daoservice.UserService;
import edu.mriabov.restapitesttask.dao.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final UserService userService;

    @PutMapping("/register")
    public HttpStatus registerUser(@RequestBody User user) {
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
