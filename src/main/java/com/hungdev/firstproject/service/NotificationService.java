package com.hungdev.firstproject.service;

import com.hungdev.firstproject.entity.UserEntity;
import com.hungdev.firstproject.model.NotificationDTO;
import com.hungdev.firstproject.model.UserDTO;

import java.util.List;

public interface NotificationService {
    List<NotificationDTO> getAllNotifications(Integer userId);
    NotificationDTO creatNotification(NotificationDTO notificationDTO);
}
