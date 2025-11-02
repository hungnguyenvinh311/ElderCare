package com.hungdev.firstproject.repository;

import com.hungdev.firstproject.entity.DoctorEntity;
import com.hungdev.firstproject.model.DoctorDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {
    DoctorEntity findDoctorByFullname(String fullname);
    List<DoctorEntity> findDoctorBySpeciality(String speciality);
    List<DoctorEntity> findDoctorsByDoctorIdIn(Long[] ids);
    // Chỉ lấy 10 bác sĩ có rating cao nhất
    List<DoctorEntity> findTop6ByOrderByRatingDesc();
}
