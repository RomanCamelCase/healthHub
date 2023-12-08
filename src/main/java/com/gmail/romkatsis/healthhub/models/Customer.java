package com.gmail.romkatsis.healthhub.models;

import com.gmail.romkatsis.healthhub.utils.enums.Gender;
import com.gmail.romkatsis.healthhub.utils.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "customers")
@PrimaryKeyJoinColumn(name = "user_id")
public class Customer extends User {

    @Column(name = "profile_picture")
    private String profilePictureLink;

    public Customer() {
    }

    public Customer(String email, String password, boolean isBanned, Gender gender, String firstName, String lastName, Date birthDate, Date registrationDate, LocalDateTime lastTimeOnline, String profilePictureLink) {
        super(email, password, isBanned, gender, firstName, lastName, birthDate, registrationDate, lastTimeOnline);
        this.profilePictureLink = profilePictureLink;
        this.addRole(Role.CUSTOMER);
    }

    public String getProfilePictureLink() {
        return profilePictureLink;
    }

    public void setProfilePictureLink(String profilePictureLink) {
        this.profilePictureLink = profilePictureLink;
    }
}
