package com.week08.zachary.repository.order;

import com.week08.zachary.model.order.OrderA;
import com.week08.zachary.model.order.OrderE;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderERepository extends JpaRepository<OrderE, Long> {
}
