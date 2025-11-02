package com.hungdev.firstproject.repository;


import com.hungdev.firstproject.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findByUserNameAndRoles_Code(String name, String roleCode);
    UserEntity findOneByUserName(String userName);
    List<UserEntity> findByRoles_Code(String roleCode);
}
