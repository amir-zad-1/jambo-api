package edu.ordering.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.ordering.models.*;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository("orderRepository")
public interface OrderRepository extends JpaRepository<Order, Long> {
}
