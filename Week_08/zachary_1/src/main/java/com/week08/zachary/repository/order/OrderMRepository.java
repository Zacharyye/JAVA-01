package com.week08.zachary.repository.order;

import com.week08.zachary.model.order.OrderA;
import com.week08.zachary.model.order.OrderM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMRepository extends JpaRepository<OrderM, Long> {
}
