package fr.upec.sirius.episaine.episaine_send_notification.repository;

import java.time.LocalDateTime;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CustomerNotificationStateRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public int updateLastNotification(Integer customerId, LocalDateTime sentAt) {
        return entityManager.createNativeQuery("""
                UPDATE gold.customers
                SET last_notification = :sentAt, updated_at = :sentAt
                WHERE customer_id = :customerId
                """)
                .setParameter("customerId", customerId)
                .setParameter("sentAt", sentAt)
                .executeUpdate();
    }
}
