package com.week07.zachary.service;

import com.week07.zachary.model.T;

public interface TService {
  void save(T t);
  T findById(Long id);
  void delete(Long id);
}
