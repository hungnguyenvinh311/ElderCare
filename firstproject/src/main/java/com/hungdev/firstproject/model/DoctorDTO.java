package com.hungdev.firstproject.model;

import jakarta.persistence.Column;

import java.util.Date;

public class DoctorDTO {
    private Long doctor_id;
    private String fullname;
    private Date dateofbirth;
    private String degree;
    private String speciality;
    private Float rating;
    private String profileimageurl;
    private String description;

    public Long getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Long doctor_id) {
        this.doctor_id = doctor_id;
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

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
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
}
