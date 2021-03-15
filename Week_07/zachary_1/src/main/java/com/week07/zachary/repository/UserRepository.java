package com.week07.zachary.repository;

import com.week07.zachary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
  List<User> findByName(String name);
}

