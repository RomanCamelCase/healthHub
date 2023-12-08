package com.gmail.romkatsis.healthhub.models;

import com.gmail.romkatsis.healthhub.utils.enums.Gender;
import com.gmail.romkatsis.healthhub.utils.enums.Role;
import com.gmail.romkatsis.healthhub.utils.enums.WorkWith;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "doctors")
@PrimaryKeyJoinColumn(name = "user_id")
public class Doctor extends User {

    @Column(name = "is_active")
    @NotNull
    private boolean isActive;

    @Column(name = "is_approved")
    @NotNull
    private boolean isApproved;

    @Column(name = "work_experience")
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date workExperience;

    @Column(name = "work_with")
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private WorkWith workWith;

    @Column(name = "description")
    private String description;

    @Column(name = "city")
    @NotNull
    private String city;

    @Column(name = "address")
    @NotNull
    private String address;

    @Column(name = "google_maps_link")
    private String googleMapsLink;

    @Column(name = "contact_number", unique = true)
    @NotNull
    private long contactNumber;

    public Doctor() {
    }

    public Doctor(String email, String password, boolean isBanned, Gender gender, String firstName, String lastName, Date birthDate, Date registrationDate, LocalDateTime lastTimeOnline, boolean isActive, boolean isApproved, Date workExperience, WorkWith workWith, String description, String city, String address, String googleMapsLink, long contactNumber) {
        super(email, password, isBanned, gender, firstName, lastName, birthDate, registrationDate, lastTimeOnline);
        this.isActive = isActive;
        this.isApproved = isApproved;
        this.workExperience = workExperience;
        this.workWith = workWith;
        this.description = description;
        this.city = city;
        this.address = address;
        this.googleMapsLink = googleMapsLink;
        this.contactNumber = contactNumber;
        this.addRole(Role.DOCTOR);
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public Date getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(Date workExperience) {
        this.workExperience = workExperience;
    }

    public WorkWith getWorkWith() {
        return workWith;
    }

    public void setWorkWith(WorkWith workWith) {
        this.workWith = workWith;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGoogleMapsLink() {
        return googleMapsLink;
    }

    public void setGoogleMapsLink(String googleMapsLink) {
        this.googleMapsLink = googleMapsLink;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }
}
