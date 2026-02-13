package fr.upec.sirius.episaine.episaine_cache_loader.service;

import java.util.List;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import fr.upec.sirius.episaine.episaine_cache_loader.dto.CustomerNotificationDTO;
import fr.upec.sirius.episaine.episaine_cache_loader.mapper.DatabaseToCacheMapper;
import fr.upec.sirius.episaine.episaine_cache_loader.model.Customer;
import fr.upec.sirius.episaine.episaine_cache_loader.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RedisTemplate<String, Object> redisTemplate;
    private static final String ACTIVE_CUSTOMERS_KEY = "customers:active";

    public void saveCustomerNotificationStatusToCache(CustomerNotificationDTO customer) {
        long epochSeconds = customer.getLastNotification().toInstant().getEpochSecond();
        String cacheKey = ACTIVE_CUSTOMERS_KEY + ":" + customer.getCustomer_id();
        redisTemplate.opsForValue().set(cacheKey, customer.getLastNotification() + ":" + epochSeconds);
    }

    public void clearCache() {
        redisTemplate.delete(ACTIVE_CUSTOMERS_KEY);
    }

    public void loadCustomersToCache() {
        clearCache();
        List<Customer> customers = customerRepository.findAllByNewsletterOptInTrue();
        List<CustomerNotificationDTO> customerNotificationDTOs = DatabaseToCacheMapper
                .toCustomerNotificationDTOList(customers);
        customerNotificationDTOs.forEach(this::saveCustomerNotificationStatusToCache);
    }
}
