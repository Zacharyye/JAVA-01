package com.week07.zachary;

import com.week07.zachary.model.T;
import com.week07.zachary.service.TService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Date;

@Slf4j
@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class Ttest {
  @Autowired
  public TService tService;

  @Test
  public void test1 () {
    //create
    T t = T.builder()
            .createTime(new Date())
            .build();
    tService.save(t);
    Assert.assertNotNull(t.getId());

    //read
    t = tService.findById(t.getId());
    Assert.assertNotNull(t.getId());

    //update
    Date updateTime = new Date();
    t.setCreateTime(updateTime);
    tService.save(t);
    t = tService.findById(t.getId());
    Assert.assertTrue(t.getCreateTime().equals(updateTime));

    //delete
    tService.delete(t.getId());
    t = tService.findById(t.getId());
    Assert.assertNull(t);

  }
}
