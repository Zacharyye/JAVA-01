package com.week07.zachary.repository;

import com.week07.zachary.model.T;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TRepository extends JpaRepository<T, Long> {
}
