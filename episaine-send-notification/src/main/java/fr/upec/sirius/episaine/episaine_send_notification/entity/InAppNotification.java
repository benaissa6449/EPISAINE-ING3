package fr.upec.sirius.episaine.episaine_send_notification.entity;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "in_app_notifications", schema = "gold")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InAppNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id", nullable = false)
    private Integer customerId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String message;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "in_app_notification_recipes", schema = "gold", joinColumns = @JoinColumn(name = "notification_id"))
    @Column(name = "recipe_id", nullable = false)
    @Builder.Default
    private Set<Integer> recipeIds = new LinkedHashSet<>();

    @Column(name = "is_read", nullable = false)
    @Builder.Default
    private Boolean isRead = false;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "expires_at", nullable = false)
    private LocalDateTime expiresAt;

    @PrePersist
    void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        createdAt = now;
        expiresAt = now.plusDays(30);
    }
}
