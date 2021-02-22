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
  `user_id` BIGINT DEFAULT NULL,
  `product_id` BIGINT DEFAULT NULL,
  `total_price` DECIMAL(15, 2) DEFAULT NULL,
  `num` DOUBLE DEFAULT NULL,
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT UNIQUE(`order_no`,`user_id`,`product_id`) 
) ENGINE = InnoDB;