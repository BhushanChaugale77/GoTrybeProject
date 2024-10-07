package com.gotrybe.notification.serviceimpl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gotrybe.notification.dto.NotificationDto;
import com.gotrybe.notification.entity.Notification;
import com.gotrybe.notification.repository.NotificationRepository;
import com.gotrybe.notification.service.NotificationServiceInterface;

@Service
public class NotificationServiceImpl implements NotificationServiceInterface {

	@Autowired
	private NotificationRepository repository;
	
	@Autowired
	private ModelMapper mapper;

	 // Send a notification (email or SMS)
	public NotificationDto sendNotification(NotificationDto notificationDto) {
 		String status = sendNotificationToAPI(notificationDto);
 		
 		Notification notification = mapper.map(notificationDto, Notification.class);
		repository.save(notification);
		NotificationDto dto = mapper.map(notification, NotificationDto.class);
		return dto;
	}

	@Override
	public Notification getNotificationById(UUID notificationId) {
		return repository.findById(notificationId).orElseThrow();
	}

	@Override
	public List<NotificationDto> getNotificationsByRecipient(String recipient) {
		return repository.findAll().stream()
						 .filter(notification -> notification.getRecipient().equals(recipient))
						 .map(notification -> new NotificationDto(notification.getNotificationId(),
								 											  notification.getRecipient(),
								 											  notification.getMessage(),
								 											  notification.getNotificationType(),
								 											  notification.getStatus(),
								 											  notification.getSentAt()))
						 .collect(Collectors.toList());
	}
	
	// Simulated method to send notifications via API (can be integrated with third-party services)
    private String sendNotificationToAPI(NotificationDto notificationDto) {
        // Here you would call the real email/SMS sending service (Twilio, SendGrid, etc.)
        return "SENT";  // Example status, can be "FAILED" if the API fails
    }
	
}
