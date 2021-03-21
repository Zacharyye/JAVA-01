package com.week08.zachary.repository.order;

import com.week08.zachary.model.order.OrderA;
import com.week08.zachary.model.order.OrderF;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderFRepository extends JpaRepository<OrderF, Long> {
}
