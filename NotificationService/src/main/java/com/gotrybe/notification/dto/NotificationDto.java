package com.gotrybe.notification.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class NotificationDto {

	
	 	private UUID notificationId;

	 	@NotBlank(message = "Recipient cannot be blank")
	    @Email(message = "Invalid email format")
  	    private String recipient; // email or phone number
	 	
	 	@NotBlank(message = "Message cannot be blank")
	    @Size(max = 255, message = "Message cannot exceed 255 characters")
 	    private String message;

	    @NotBlank(message = "Notification type cannot be blank")
	    @Pattern(regexp = "^(EMAIL|SMS)$", message = "Notification type must be either EMAIL or SMS")
 	    private String notificationType; // EMAIL, SMS
	    
	    @NotBlank(message = "Status cannot be blank")
	    @Pattern(regexp = "^(PENDING|SENT|FAILED)$", message = "Status must be either PENDING, SENT, or FAILED")
 	    private String status; // PENDING, SENT, FAILED

 	    private LocalDateTime sentAt;

		public NotificationDto() {
			super();
 		}
		
		public NotificationDto(UUID notificationId, String recipient, String message, String notificationType,
				String status, LocalDateTime sentAt) {
			super();
			this.notificationId = notificationId;
			this.recipient = recipient;
			this.message = message;
			this.notificationType = notificationType;
			this.status = status;
			this.sentAt = sentAt;
		}



		public UUID getNotificationId() {
			return notificationId;
		}

		public void setNotificationId(UUID notificationId) {
			this.notificationId = notificationId;
		}

		public String getRecipient() {
			return recipient;
		}

		public void setRecipient(String recipient) {
			this.recipient = recipient;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getNotificationType() {
			return notificationType;
		}

		public void setNotificationType(String notificationType) {
			this.notificationType = notificationType;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public LocalDateTime getSentAt() {
			return sentAt;
		}

		public void setSentAt(LocalDateTime sentAt) {
			this.sentAt = sentAt;
		}

		@Override
		public String toString() {
			return "NotificationDto [notificationId=" + notificationId + ", recipient=" + recipient + ", message="
					+ message + ", notificationType=" + notificationType + ", status=" + status + ", sentAt=" + sentAt
					+ "]";
		}
}
