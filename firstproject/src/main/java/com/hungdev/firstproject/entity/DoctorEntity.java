package com.hungdev.firstproject.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Doctors")
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long doctorId;

    @Column(name = "fullname",  nullable = false)
    private String fullname;

    @Column(name = "dateofbirth")
    private Date dateofbirth;

    @Column(name = "degree")
    private String degree;

    @Column(name = "speciality")
    private String speciality;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "profileimageurl")
    private String profileimageurl;

    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "DoctorPatients",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<UserEntity> userEntities = new ArrayList<>();

    @OneToMany(
            mappedBy = "doctor", // "doctor" là tên thuộc tính (field) trong Appointment.java
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<AppointmentEntity> appointments = new ArrayList<>();

    public List<AppointmentEntity> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<AppointmentEntity> appointments) {
        this.appointments = appointments;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getProfileimageurl() {
        return profileimageurl;
    }

    public void setProfileimageurl(String profileimageurl) {
        this.profileimageurl = profileimageurl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UserEntity> getUserEntities() {
        return userEntities;
    }

    public void setUserEntities(List<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }
}
