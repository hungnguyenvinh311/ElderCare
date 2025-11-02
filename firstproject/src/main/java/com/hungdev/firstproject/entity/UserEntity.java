package com.hungdev.firstproject.entity;

import com.hungdev.firstproject.entity.RoleEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "user")

public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "age")
    private Integer age;

    @Column(name = "email")
    private String email;

    @Column(name = "phonenumber")
    private String phonenumber;

    @Column(name = "address")
    private String address;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "role_id", nullable = false))
    private List<RoleEntity> roles = new ArrayList<>();


    @ManyToMany(mappedBy = "userEntities", fetch = FetchType.LAZY)
    private List<DoctorEntity> doctorEntities = new ArrayList<>();


    @OneToMany(mappedBy = "user", // "user" là tên thuộc tính (field) trong Appointment.java
            cascade = CascadeType.ALL, // Tùy chọn: Xóa user thì xóa luôn cuộc hẹn
            orphanRemoval = true // Tùy chọn: Xóa cuộc hẹn khỏi list thì xóa luôn trong DB
    )
    private List<AppointmentEntity> appointments = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }

    public List<DoctorEntity> getDoctorEntities() {
        return doctorEntities;
    }

    public void setDoctorEntities(List<DoctorEntity> doctorEntities) {
        this.doctorEntities = doctorEntities;
    }

    public List<AppointmentEntity> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<AppointmentEntity> appointments) {
        this.appointments = appointments;
    }
}