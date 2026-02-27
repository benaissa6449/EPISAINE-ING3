package fr.upec.sirius.episaine.episaine_send_notification.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.upec.sirius.episaine.episaine_send_notification.entity.InAppNotification;

public interface NotificationRepository extends JpaRepository<InAppNotification, Long> {
    
    @Query("SELECT n FROM InAppNotification n WHERE n.customerId = :customerId ORDER BY n.createdAt DESC")
    List<InAppNotification> findByCustomerId(@Param("customerId") Integer customerId);
    
    @Modifying
    @Query("UPDATE InAppNotification n SET n.isRead = true WHERE n.id = :id")
    void markAsRead(@Param("id") Long id);
    
    @Modifying
    @Query("DELETE FROM InAppNotification n WHERE n.expiresAt < :now")
    int deleteExpired(@Param("now") LocalDateTime now);
}
