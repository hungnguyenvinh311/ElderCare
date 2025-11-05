package com.hungdev.firstproject.api;


import com.hungdev.firstproject.model.NotificationDTO;
import com.hungdev.firstproject.model.UserDTO;
import com.hungdev.firstproject.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@Transactional
public class NotificationAPI {

    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public List<NotificationDTO> getAllNotifications(@RequestParam Integer userId){
        List<NotificationDTO> dtos = notificationService.getAllNotifications(userId);
        return dtos;
    }

    @PostMapping
    public void newNotifications(@RequestBody NotificationDTO notificationDTO){
        notificationService.creatNotification(notificationDTO);
    }

}
