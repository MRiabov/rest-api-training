package edu.mriabov.restapitesttask.dao.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import java.util.Date;

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NonNull
    @Email
    private String email;

    private String firstName;

    private String lastName;

    @Past
    private Date birthDate;

    private String address;

    private String phoneNumber;

}
