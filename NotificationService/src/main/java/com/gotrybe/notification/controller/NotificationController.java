package com.gotrybe.notification.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gotrybe.notification.dto.NotificationDto;
import com.gotrybe.notification.entity.Notification;
import com.gotrybe.notification.service.NotificationServiceInterface;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/notification")
public class NotificationController {

	
	@Autowired
	private NotificationServiceInterface serviceInterface;
	
	@GetMapping("/notificationId")
	public ResponseEntity<Notification> getNotificationById(@PathVariable UUID notificationId) {
 		return new ResponseEntity<Notification>(serviceInterface.getNotificationById(notificationId),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<NotificationDto> sendNotification(@Valid @RequestBody NotificationDto notificationDto, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);
			});
				return new ResponseEntity(map,HttpStatus.BAD_REQUEST);
		}
			return new ResponseEntity<NotificationDto>(serviceInterface.sendNotification(notificationDto),HttpStatus.OK);
	}
	
	@GetMapping("/recipient/{recipient}")
	public ResponseEntity<Notification> getNotificationsByRecipient(@PathVariable String recipient){
		serviceInterface.getNotificationsByRecipient(recipient);
		return new ResponseEntity<Notification>(HttpStatus.OK);
	}
		 
	
	
	
}
