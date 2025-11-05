package com.hungdev.firstproject.repository;

import com.hungdev.firstproject.entity.NotificationEntity;
import com.hungdev.firstproject.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {
    List<NotificationEntity> findAllByNotificationType(String notificationType);

    List<NotificationEntity> findByUserAndIsReadFalseOrderByCreatedAtDesc(UserEntity recipient);
}
