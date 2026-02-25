package fr.upec.sirius.episaine.episaine_cache_loader.service;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import fr.upec.sirius.episaine.episaine_cache_loader.data.model.Customer;
import fr.upec.sirius.episaine.episaine_cache_loader.dto.CustomerNotificationDTO;
import fr.upec.sirius.episaine.episaine_cache_loader.mapper.DatabaseToCacheMapper;
import fr.upec.sirius.episaine.episaine_cache_loader.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RedisTemplate<String, Object> redisTemplate;
    private static final String ACTIVE_CUSTOMERS_KEY = "customers:active";
    private static final int PAGE_SIZE = 5000;

    public void saveCustomerNotificationStatusToCache(CustomerNotificationDTO customer) {
        long epochSeconds = customer.getLastNotification().toInstant().getEpochSecond();
        String cacheKey = ACTIVE_CUSTOMERS_KEY + ":" + customer.getCustomer_id();
        redisTemplate.opsForValue().set(cacheKey, customer.getLastNotification() + ":" + epochSeconds);
    }

    public void clearCache() {
        Set<String> keys = redisTemplate.keys(ACTIVE_CUSTOMERS_KEY + ":*");
        if (keys != null && !keys.isEmpty()) {
            redisTemplate.delete(keys);
            System.out.println("Cleared " + keys.size() + " keys from Redis cache.");
        }
    }

    public void loadCustomersToCache() {
        clearCache();
        Pageable pageable = PageRequest.of(0, PAGE_SIZE);
        Page<Customer> page;
        int totalLoaded = 0;

        do {
            page = customerRepository.findAllByNewsletterOptInTrue(pageable);
            page.getContent().stream()
                    .map(DatabaseToCacheMapper::toCustomerNotificationDTO)
                    .forEach(this::saveCustomerNotificationStatusToCache);
            totalLoaded += page.getNumberOfElements();
            System.out.println("Loaded " + totalLoaded + "/" + page.getTotalElements() + " customers to cache...");
            pageable = page.nextPageable();
        } while (page.hasNext());

        System.out.println("Done: " + totalLoaded + " customers loaded to cache.");
    }
}
