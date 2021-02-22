package com.zachary.zzzz.repository;

import com.zachary.zzzz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
