package edu.ordering.repositories;

import edu.ordering.models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("orderItemRepository")
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
