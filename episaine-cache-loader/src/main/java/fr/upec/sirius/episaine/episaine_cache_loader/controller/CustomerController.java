package fr.upec.sirius.episaine.episaine_cache_loader.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.upec.sirius.episaine.episaine_cache_loader.service.CustomerService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/load-cache")
    public String loadCustomersToCache() {
        customerService.loadCustomersToCache();
        return "Cache loaded successfully";
    }
}
