package com.gotrybe.notification.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.gotrybe.notification.dto.NotificationDto;
import com.gotrybe.notification.entity.Notification;

public interface NotificationServiceInterface {

	
	NotificationDto sendNotification(NotificationDto notificationDto);
	
	Notification getNotificationById(UUID notificationId);
	
	List<NotificationDto> getNotificationsByRecipient(String recipient);
	
}
