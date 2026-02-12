package fr.upec.sirius.episaine.episaine_cache_loader.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.upec.sirius.episaine.episaine_cache_loader.service.CustomerService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public void getCustomersToNotify() {
        customerService.loadCustomersToCache();
    }
}
