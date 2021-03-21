-- 订单1
CREATE TABLE `e-commerce`.`order_a`  (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `order_no` VARCHAR(255) DEFAULT NULL,
  `status` VARCHAR(2) DEFAULT NULL,
  `user_id` BIGINT DEFAULT NULL,
  `product_id` BIGINT DEFAULT NULL,
  `worksite` VARCHAR(1000) DEFAULT NULL,
  `remark` VARCHAR(1000) DEFAULT NULL,
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  `submit_time` TIMESTAMP NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT UNIQUE(`order_no`,`user_id`,`product_id`) 
) ENGINE = InnoDB;

-- 订单2
CREATE TABLE `e-commerce`.`order_b`  (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `order_no` VARCHAR(255) DEFAULT NULL,
  `status` VARCHAR(2) DEFAULT NULL,
  `user_id` BIGINT DEFAULT NULL,
  `product_id` BIGINT DEFAULT NULL,
  `worksite` VARCHAR(1000) DEFAULT NULL,
  `remark` VARCHAR(1000) DEFAULT NULL,
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  `submit_time` TIMESTAMP NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT UNIQUE(`order_no`,`user_id`,`product_id`) 
) ENGINE = InnoDB;

-- 订单3
CREATE TABLE `e-commerce`.`order_c`  (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `order_no` VARCHAR(255) DEFAULT NULL,
  `status` VARCHAR(2) DEFAULT NULL,
  `user_id` BIGINT DEFAULT NULL,
  `product_id` BIGINT DEFAULT NULL,
  `worksite` VARCHAR(1000) DEFAULT NULL,
  `remark` VARCHAR(1000) DEFAULT NULL,
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  `submit_time` TIMESTAMP NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT UNIQUE(`order_no`,`user_id`,`product_id`) 
) ENGINE = InnoDB;

-- 订单4
CREATE TABLE `e-commerce`.`order_e`  (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `order_no` VARCHAR(255) DEFAULT NULL,
  `status` VARCHAR(2) DEFAULT NULL,
  `user_id` BIGINT DEFAULT NULL,
  `product_id` BIGINT DEFAULT NULL,
  `worksite` VARCHAR(1000) DEFAULT NULL,
  `remark` VARCHAR(1000) DEFAULT NULL,
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  `submit_time` TIMESTAMP NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT UNIQUE(`order_no`,`user_id`,`product_id`) 
) ENGINE = InnoDB;

-- 订单5
CREATE TABLE `e-commerce`.`order_f`  (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `order_no` VARCHAR(255) DEFAULT NULL,
  `status` VARCHAR(2) DEFAULT NULL,
  `user_id` BIGINT DEFAULT NULL,
  `product_id` BIGINT DEFAULT NULL,
  `worksite` VARCHAR(1000) DEFAULT NULL,
  `remark` VARCHAR(1000) DEFAULT NULL,
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  `submit_time` TIMESTAMP NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT UNIQUE(`order_no`,`user_id`,`product_id`) 
) ENGINE = InnoDB;

-- 订单6
CREATE TABLE `e-commerce`.`order_g`  (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `order_no` VARCHAR(255) DEFAULT NULL,
  `status` VARCHAR(2) DEFAULT NULL,
  `user_id` BIGINT DEFAULT NULL,
  `product_id` BIGINT DEFAULT NULL,
  `worksite` VARCHAR(1000) DEFAULT NULL,
  `remark` VARCHAR(1000) DEFAULT NULL,
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  `submit_time` TIMESTAMP NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT UNIQUE(`order_no`,`user_id`,`product_id`) 
) ENGINE = InnoDB;

-- 订单7
CREATE TABLE `e-commerce`.`order_h`  (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `order_no` VARCHAR(255) DEFAULT NULL,
  `status` VARCHAR(2) DEFAULT NULL,
  `user_id` BIGINT DEFAULT NULL,
  `product_id` BIGINT DEFAULT NULL,
  `worksite` VARCHAR(1000) DEFAULT NULL,
  `remark` VARCHAR(1000) DEFAULT NULL,
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  `submit_time` TIMESTAMP NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT UNIQUE(`order_no`,`user_id`,`product_id`) 
) ENGINE = InnoDB;

-- 订单8
CREATE TABLE `e-commerce`.`order_i`  (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `order_no` VARCHAR(255) DEFAULT NULL,
  `status` VARCHAR(2) DEFAULT NULL,
  `user_id` BIGINT DEFAULT NULL,
  `product_id` BIGINT DEFAULT NULL,
  `worksite` VARCHAR(1000) DEFAULT NULL,
  `remark` VARCHAR(1000) DEFAULT NULL,
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  `submit_time` TIMESTAMP NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT UNIQUE(`order_no`,`user_id`,`product_id`) 
) ENGINE = InnoDB;

-- 订单9
CREATE TABLE `e-commerce`.`order_j`  (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `order_no` VARCHAR(255) DEFAULT NULL,
  `status` VARCHAR(2) DEFAULT NULL,
  `user_id` BIGINT DEFAULT NULL,
  `product_id` BIGINT DEFAULT NULL,
  `worksite` VARCHAR(1000) DEFAULT NULL,
  `remark` VARCHAR(1000) DEFAULT NULL,
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  `submit_time` TIMESTAMP NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT UNIQUE(`order_no`,`user_id`,`product_id`) 
) ENGINE = InnoDB;

-- 订单10
CREATE TABLE `e-commerce`.`order_k`  (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `order_no` VARCHAR(255) DEFAULT NULL,
  `status` VARCHAR(2) DEFAULT NULL,
  `user_id` BIGINT DEFAULT NULL,
  `product_id` BIGINT DEFAULT NULL,
  `worksite` VARCHAR(1000) DEFAULT NULL,
  `remark` VARCHAR(1000) DEFAULT NULL,
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  `submit_time` TIMESTAMP NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT UNIQUE(`order_no`,`user_id`,`product_id`) 
) ENGINE = InnoDB;

-- 订单11
CREATE TABLE `e-commerce`.`order_l`  (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `order_no` VARCHAR(255) DEFAULT NULL,
  `status` VARCHAR(2) DEFAULT NULL,
  `user_id` BIGINT DEFAULT NULL,
  `product_id` BIGINT DEFAULT NULL,
  `worksite` VARCHAR(1000) DEFAULT NULL,
  `remark` VARCHAR(1000) DEFAULT NULL,
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  `submit_time` TIMESTAMP NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT UNIQUE(`order_no`,`user_id`,`product_id`) 
) ENGINE = InnoDB;

-- 订单12
CREATE TABLE `e-commerce`.`order_m`  (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `order_no` VARCHAR(255) DEFAULT NULL,
  `status` VARCHAR(2) DEFAULT NULL,
  `user_id` BIGINT DEFAULT NULL,
  `product_id` BIGINT DEFAULT NULL,
  `worksite` VARCHAR(1000) DEFAULT NULL,
  `remark` VARCHAR(1000) DEFAULT NULL,
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  `submit_time` TIMESTAMP NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT UNIQUE(`order_no`,`user_id`,`product_id`) 
) ENGINE = InnoDB;

-- 订单13
CREATE TABLE `e-commerce`.`order_n`  (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `order_no` VARCHAR(255) DEFAULT NULL,
  `status` VARCHAR(2) DEFAULT NULL,
  `user_id` BIGINT DEFAULT NULL,
  `product_id` BIGINT DEFAULT NULL,
  `worksite` VARCHAR(1000) DEFAULT NULL,
  `remark` VARCHAR(1000) DEFAULT NULL,
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  `submit_time` TIMESTAMP NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT UNIQUE(`order_no`,`user_id`,`product_id`) 
) ENGINE = InnoDB;

-- 订单14
CREATE TABLE `e-commerce`.`order_o`  (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `order_no` VARCHAR(255) DEFAULT NULL,
  `status` VARCHAR(2) DEFAULT NULL,
  `user_id` BIGINT DEFAULT NULL,
  `product_id` BIGINT DEFAULT NULL,
  `worksite` VARCHAR(1000) DEFAULT NULL,
  `remark` VARCHAR(1000) DEFAULT NULL,
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  `submit_time` TIMESTAMP NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT UNIQUE(`order_no`,`user_id`,`product_id`) 
) ENGINE = InnoDB;

-- 订单15
CREATE TABLE `e-commerce`.`order_p`  (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `order_no` VARCHAR(255) DEFAULT NULL,
  `status` VARCHAR(2) DEFAULT NULL,
  `user_id` BIGINT DEFAULT NULL,
  `product_id` BIGINT DEFAULT NULL,
  `worksite` VARCHAR(1000) DEFAULT NULL,
  `remark` VARCHAR(1000) DEFAULT NULL,
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  `submit_time` TIMESTAMP NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT UNIQUE(`order_no`,`user_id`,`product_id`) 
) ENGINE = InnoDB;

-- 订单16
CREATE TABLE `e-commerce`.`order_q`  (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `order_no` VARCHAR(255) DEFAULT NULL,
  `status` VARCHAR(2) DEFAULT NULL,
  `user_id` BIGINT DEFAULT NULL,
  `product_id` BIGINT DEFAULT NULL,
  `worksite` VARCHAR(1000) DEFAULT NULL,
  `remark` VARCHAR(1000) DEFAULT NULL,
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  `submit_time` TIMESTAMP NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT UNIQUE(`order_no`,`user_id`,`product_id`) 
) ENGINE = InnoDB;

-- 用户
CREATE TABLE `e-commerce`.`user`  (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(255) DEFAULT NULL,
  `mobile` VARCHAR(255) DEFAULT NULL,
  `email` VARCHAR(255) DEFAULT NULL,
  `sex` VARCHAR(255) DEFAULT NULL,
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB;

 -- 产品
 CREATE TABLE `e-commerce`.`product`  (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `product_no` VARCHAR(255) DEFAULT NULL,
  `product_name` VARCHAR(255) DEFAULT NULL,
  `unit_price` DECIMAL(15, 2) DEFAULT NULL,
  `unit` DOUBLE DEFAULT NULL,
  `unit_name` VARCHAR(12) DEFAULT NULL,
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB;

-- 订单
CREATE TABLE `e-commerce`.`order`  (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `order_no` VARCHAR(255) DEFAULT NULL,
  `status` VARCHAR(2) DEFAULT NULL,
  `user_id` BIGINT DEFAULT NULL,
  `product_id` BIGINT DEFAULT NULL,
  `worksite` VARCHAR(1000) DEFAULT NULL,
  `remark` VARCHAR(1000) DEFAULT NULL,
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  `submit_time` TIMESTAMP NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT UNIQUE(`order_no`,`user_id`,`product_id`) 
) ENGINE = InnoDB;

-- 订单快照
CREATE TABLE `e-commerce`.`orderSnapshot`  (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `order_no` VARCHAR(255) DEFAULT NULL,
  `status` VARCHAR(2) DEFAULT NULL,
  `product_no` VARCHAR(255) DEFAULT NULL,
  `product_name` VARCHAR(255) DEFAULT NULL,
  `total_price` DECIMAL(15, 2) DEFAULT NULL,
  `retail_price` DECIMAL(15, 2) DEFAULT NULL,
  `vip_unit_price` DECIMAL(15, 2) DEFAULT NULL,
  `market_price` DECIMAL(15, 2) DEFAULT NULL,
  `unit` VARCHAR(255) DEFAULT NULL,
  `num` DOUBLE DEFAULT NULL,
  `refund_num` DOUBLE DEFAULT NULL,
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  `receive_time` TIMESTAMP NULL,
  `deliver_time` TIMESTAMP NULL,
  `receipt_time` TIMESTAMP NULL
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT UNIQUE(`order_no`,`product_no`) 
) ENGINE = InnoDB;