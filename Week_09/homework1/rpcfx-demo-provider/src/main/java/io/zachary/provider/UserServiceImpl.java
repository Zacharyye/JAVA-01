package io.zachary.provider;

import io.zachary.api.User;
import io.zachary.api.UserService;

public class UserServiceImpl implements UserService {
  @Override
  public User findById(int id) {
    return new User(id, "KK" + System.currentTimeMillis());
  }
}
