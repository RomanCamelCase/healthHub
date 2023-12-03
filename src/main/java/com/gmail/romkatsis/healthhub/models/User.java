package com.gmail.romkatsis.healthhub.models;

import com.gmail.romkatsis.healthhub.utils.enums.Gender;
import com.gmail.romkatsis.healthhub.utils.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Entity(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Getter
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Column(name = "email", unique = true)
    @NotNull
    @Max(value = 100)
    @Email
    private String email;

    @Getter
    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "is_banned")
    @NotNull
    private boolean isBanned;

    @Getter
    @Column(name = "sex")
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    @Getter
    @Column(name = "first_name")
    @NotNull
    @Max(value = 30)
    private String firstName;

    @Getter
    @Column(name = "last_name")
    @NotNull
    @Max(value = 30)
    private String lastName;

    @Getter
    @Column(name = "birth_day")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Getter
    @ElementCollection(fetch = FetchType.EAGER, targetClass = Role.class)
    @CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private List<Role> roles;

    public User() {
    }

    public User(String email, String password, boolean isBanned, Gender gender, String firstName, String lastName, Date birthDate, List<Role> roles) {
        this.email = email;
        this.password = password;
        this.isBanned = isBanned;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.roles = roles;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
