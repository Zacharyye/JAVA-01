package com.week08.zachary.repository.order;

import com.week08.zachary.model.order.OrderA;
import com.week08.zachary.model.order.OrderH;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderHRepository extends JpaRepository<OrderH, Long> {
}
