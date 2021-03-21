package com.week08.zachary.repository.order;

import com.week08.zachary.model.order.OrderA;
import com.week08.zachary.model.order.OrderL;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLRepository extends JpaRepository<OrderL, Long> {
}
