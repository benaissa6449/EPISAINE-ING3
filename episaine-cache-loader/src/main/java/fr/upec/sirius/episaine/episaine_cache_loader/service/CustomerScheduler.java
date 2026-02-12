package fr.upec.sirius.episaine.episaine_cache_loader.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerScheduler {
    private final CustomerService customerService;

    @Scheduled(initialDelay = 0, fixedRate = 6 * 60 * 60 * 1000)
    public void loadCustomersToCache() {
        System.out.println("Loading customers to cache...");
        customerService.loadCustomersToCache();
    }
}
