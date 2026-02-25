package fr.upec.sirius.episaine.episaine_cache_loader.mapper;

import java.util.List;

import fr.upec.sirius.episaine.episaine_cache_loader.data.model.Customer;
import fr.upec.sirius.episaine.episaine_cache_loader.dto.CustomerNotificationDTO;

public class DatabaseToCacheMapper {

    public static CustomerNotificationDTO toCustomerNotificationDTO(Customer customer) {
        return CustomerNotificationDTO.builder()
                .customer_id(customer.getCustomer_id())
                .lastNotification(customer.getLastNotification())
                .build();
    }

    public static List<CustomerNotificationDTO> toCustomerNotificationDTOList(List<Customer> customers) {
        return customers.stream() .map(DatabaseToCacheMapper::toCustomerNotificationDTO) .toList();
    }
}
