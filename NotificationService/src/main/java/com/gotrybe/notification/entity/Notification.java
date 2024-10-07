package com.gotrybe.notification.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Notification {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private UUID notificationId;

	    @Column(nullable = false)
	    private String recipient; // email or phone number

	    @Column(nullable = false)
	    private String message;

	    @Column(nullable = false)
	    private String notificationType; // EMAIL, SMS

	    @Column(nullable = false)
	    private String status; // PENDING, SENT, FAILED

	    @Column(nullable = false)
	    private LocalDateTime sentAt;

		public Notification() {
			super();
 		}
		
		public Notification(UUID notificationId, String recipient, String message, String notificationType,
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
			return "Notification [notificationId=" + notificationId + ", recipient=" + recipient + ", message="
					+ message + ", notificationType=" + notificationType + ", status=" + status + ", sentAt=" + sentAt
					+ "]";
		}
}
