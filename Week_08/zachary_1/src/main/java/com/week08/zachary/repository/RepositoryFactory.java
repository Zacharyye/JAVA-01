package com.week08.zachary.repository;

import com.week08.zachary.entity.OrderVo;
import com.week08.zachary.model.order.*;
import com.week08.zachary.repository.order.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class RepositoryFactory {
  @Autowired
  private OrderARepository orderARepository;
  @Autowired
  private OrderBRepository orderBRepository;
  @Autowired
  private OrderCRepository orderCRepository;
  @Autowired
  private OrderDRepository orderDRepository;
  @Autowired
  private OrderERepository orderERepository;
  @Autowired
  private OrderFRepository orderFRepository;
  @Autowired
  private OrderGRepository orderGRepository;
  @Autowired
  private OrderHRepository orderHRepository;
  @Autowired
  private OrderIRepository orderIRepository;
  @Autowired
  private OrderJRepository orderJRepository;
  @Autowired
  private OrderKRepository orderKRepository;
  @Autowired
  private OrderLRepository orderLRepository;
  @Autowired
  private OrderMRepository orderMRepository;
  @Autowired
  private OrderNRepository orderNRepository;
  @Autowired
  private OrderORepository orderORepository;
  @Autowired
  private OrderPRepository orderPRepository;

  @Value("${order.table.num}")
  private int orderTableNum;

  public JpaRepository getOrderRepository(OrderVo orderVo) {
    String suffix = orderVo.getOrderNo().substring(orderVo.getOrderNo().length() - 2);
    int suffixNum = Integer.valueOf(suffix);
    switch (suffixNum) {
      case 0:
        return orderARepository;
      case 1:
        return orderBRepository;
      case 2:
        return orderCRepository;
      case 3:
        return orderDRepository;
      case 4:
        return orderERepository;
      case 5:
        return orderFRepository;
      case 6:
        return orderGRepository;
      case 7:
        return orderHRepository;
      case 8:
        return orderIRepository;
      case 9:
        return orderJRepository;
      case 10:
        return orderKRepository;
      case 11:
        return orderLRepository;
      case 12:
        return orderMRepository;
      case 13:
        return orderNRepository;
      case 14:
        return orderORepository;
      case 15:
        return orderPRepository;
      default:
       return orderARepository;
    }
  }

  public Object getOrderModel(OrderVo orderVo) {
    String suffix = orderVo.getOrderNo().substring(orderVo.getOrderNo().length() - 2);
    int suffixNum = Integer.valueOf(suffix) % orderTableNum;
    switch (suffixNum) {
      case 0:
        OrderA orderA = OrderA.builder().build();
        BeanUtils.copyProperties(orderVo, orderA);
        return orderA;
      case 1:
        OrderB orderB = OrderB.builder().build();
        BeanUtils.copyProperties(orderVo, orderB);
        return orderB;
      case 2:
        OrderC orderC = OrderC.builder().build();
        BeanUtils.copyProperties(orderVo, orderC);
        return orderC;
      case 3:
        OrderD orderD = OrderD.builder().build();
        BeanUtils.copyProperties(orderVo, orderD);
        return orderD;
      case 4:
        OrderE orderE = OrderE.builder().build();
        BeanUtils.copyProperties(orderVo, orderE);
        return orderE;
      case 5:
        OrderF orderF = OrderF.builder().build();
        BeanUtils.copyProperties(orderVo, orderF);
        return orderF;
      case 6:
        OrderG orderG = OrderG.builder().build();
        BeanUtils.copyProperties(orderVo, orderG);
        return orderG;
      case 7:
        OrderH orderH = OrderH.builder().build();
        BeanUtils.copyProperties(orderVo, orderH);
        return orderH;
      case 8:
        OrderI orderI = OrderI.builder().build();
        BeanUtils.copyProperties(orderVo, orderI);
        return orderI;
      case 9:
        OrderJ orderJ = OrderJ.builder().build();
        BeanUtils.copyProperties(orderVo, orderJ);
        return orderJ;
      case 10:
        OrderK orderK = OrderK.builder().build();
        BeanUtils.copyProperties(orderVo, orderK);
        return orderK;
      case 11:
        OrderL orderL = OrderL.builder().build();
        BeanUtils.copyProperties(orderVo, orderL);
        return orderL;
      case 12:
        OrderM orderM = OrderM.builder().build();
        BeanUtils.copyProperties(orderVo, orderM);
        return orderM;
      case 13:
        OrderN orderN = OrderN.builder().build();
        BeanUtils.copyProperties(orderVo, orderN);
        return orderN;
      case 14:
        OrderO orderO = OrderO.builder().build();
        BeanUtils.copyProperties(orderVo, orderO);
        return orderO;
      case 15:
        OrderP orderP = OrderP.builder().build();
        BeanUtils.copyProperties(orderVo, orderP);
        return orderP;
      default:
        OrderA orderA_t = OrderA.builder().build();
        BeanUtils.copyProperties(orderVo, orderA_t);
        return orderA_t;
    }
  }
}
