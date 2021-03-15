package com.week07.zachary.service.impl;

import com.week07.zachary.model.T;
import com.week07.zachary.repository.TRepository;
import com.week07.zachary.service.TService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.Serializable;

@Service("tService")
public class TServiceImpl implements TService, Serializable {
  @Autowired
  private TRepository tRepository;

  @Override
  public void save(T t) {
    tRepository.save(t);
  }

  @Override
  public T findById (Long id) {
    return tRepository.findById(id).orElse(null);
  }

  @Override
  public void delete(Long id) {
    tRepository.deleteById(id);
  }
}
