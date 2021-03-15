package com.week07.zachary.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

public class DynamicDataSource extends AbstractRoutingDataSource {
  @Nullable
  @Override
  protected Object determineCurrentLookupKey() {
    return DSContextHolder.get();
  }
}
