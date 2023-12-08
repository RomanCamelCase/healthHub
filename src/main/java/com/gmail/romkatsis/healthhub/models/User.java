package com.gmail.romkatsis.healthhub.models;

import com.gmail.romkatsis.healthhub.utils.enums.Gender;
import com.gmail.romkatsis.healthhub.utils.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
import java.util.*;

@Entity(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
abstract class User {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email", unique = true)
    @NotNull
    @Size(max = 100)
    @Email
    private String email;

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "is_banned")
    @NotNull
    private boolean isBanned;

    @Column(name = "gender")
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    @Column(name = "first_name")
    @NotNull
    @Size(max = 30)
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    @Size(max = 30)
    private String lastName;

    @Column(name = "birth_day")
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name = "registration_date")
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date registrationDate;

    @Column(name = "last_time_online")
    @NotNull
    private LocalDateTime lastTimeOnline;

    @ElementCollection(fetch = FetchType.EAGER, targetClass = Role.class)
    @CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;


    public User() {
    }

    public User(String email, String password, boolean isBanned, Gender gender, String firstName, String lastName, Date birthDate, Date registrationDate, LocalDateTime lastTimeOnline) {
        this.email = email;
        this.password = password;
        this.isBanned = isBanned;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.registrationDate = registrationDate;
        this.lastTimeOnline = lastTimeOnline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDateTime getLastTimeOnline() {
        return lastTimeOnline;
    }

    public void setLastTimeOnline(LocalDateTime lastTimeOnline) {
        this.lastTimeOnline = lastTimeOnline;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        if (this.roles.isEmpty()) {
            this.roles = new HashSet<>(Collections.singleton(role));
            return;
        }
        this.roles.add(role);
    }
}
