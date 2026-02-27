package fr.upec.sirius.episaine.episaine_send_notification.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.upec.sirius.episaine.episaine_send_notification.dto.RecipeDto;
import fr.upec.sirius.episaine.episaine_send_notification.entity.InAppNotification;
import fr.upec.sirius.episaine.episaine_send_notification.service.NotificationService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class NotificationController {

    private final NotificationService service;

    @GetMapping("/customer/{customerId}")
    public List<InAppNotification> getNotifications(@PathVariable Integer customerId) {
        return service.getNotifications(customerId);
    }

    @GetMapping("/customer/{customerId}/recipes")
    public List<RecipeDto> getRecipes(@PathVariable Integer customerId) {
        return service.getRecipesByCustomerId(customerId);
    }

    @PutMapping("/{id}/read")
    public void markAsRead(@PathVariable Long id) {
        service.markAsRead(id);
    }
}
