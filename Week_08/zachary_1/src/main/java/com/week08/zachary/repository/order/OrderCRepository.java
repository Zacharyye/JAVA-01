package com.week08.zachary.repository.order;

import com.week08.zachary.model.order.OrderA;
import com.week08.zachary.model.order.OrderC;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderCRepository extends JpaRepository<OrderC, Long> {
}
