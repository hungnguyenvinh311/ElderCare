package com.hungdev.firstproject.service.impl;

import com.hungdev.firstproject.converter.NotificationConverter;
import com.hungdev.firstproject.converter.UserConverter;
import com.hungdev.firstproject.entity.NotificationEntity;
import com.hungdev.firstproject.entity.UserEntity;
import com.hungdev.firstproject.model.NotificationDTO;
import com.hungdev.firstproject.model.UserDTO;
import com.hungdev.firstproject.repository.NotificationRepository;
import com.hungdev.firstproject.service.IUserService;
import com.hungdev.firstproject.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private NotificationConverter notificationConverter;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private IUserService iUserService;

    @Override
    public List<NotificationDTO> getAllNotifications(Integer userId) {
        UserDTO userDTO = iUserService.findUserById(userId);
        UserEntity user = userConverter.convertToEntity(userDTO);
        List<NotificationEntity> notificationEntities = notificationRepository.findByUserAndIsReadFalseOrderByCreatedAtDesc(user);
        List<NotificationDTO> dtos = new ArrayList<>();
        for(NotificationEntity it : notificationEntities){
            dtos.add(notificationConverter.convertToDto(it));
        }
        return dtos;
    }

    @Override
    public NotificationDTO creatNotification(NotificationDTO notificationDTO) {
        UserDTO recipientUser = iUserService.findUserById(notificationDTO.getRecipientId());
        NotificationEntity notification = new NotificationEntity();

        notification.setUser(userConverter.convertToEntity(recipientUser));
        notification.setMessage(notificationDTO.getMessage());
        notification.setNotificationType(notificationDTO.getNotificationType());
        notification.setReferenceId(notificationDTO.getReferenceId());
        notification.setRead(false);
        notificationRepository.save(notification);
        return null;
    }
}
