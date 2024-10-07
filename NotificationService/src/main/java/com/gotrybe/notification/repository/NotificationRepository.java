package com.gotrybe.notification.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gotrybe.notification.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, UUID> {

}
