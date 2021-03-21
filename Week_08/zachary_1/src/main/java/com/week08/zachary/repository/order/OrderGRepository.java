package com.week08.zachary.repository.order;

import com.week08.zachary.model.order.OrderA;
import com.week08.zachary.model.order.OrderG;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderGRepository extends JpaRepository<OrderG, Long> {
}
