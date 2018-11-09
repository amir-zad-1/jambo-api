package edu.ordering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.ordering.models.*;
import java.util.List;
public interface OrderRepository extends JpaRepository<Order, Long> {
	List<Order> getOrdersByProduct(Product product);
}
