DROP table IF EXISTS `order_0`;
DROP table IF EXISTS `order_1`;
DROP table IF EXISTS `order_2`;
DROP table IF EXISTS `order_3`;
DROP table IF EXISTS `order_4`;
DROP table IF EXISTS `order_5`;
DROP table IF EXISTS `order_6`;
DROP table IF EXISTS `order_7`;
DROP table IF EXISTS `order_8`;
DROP table IF EXISTS `order_9`;
DROP table IF EXISTS `order_10`;
DROP table IF EXISTS `order_11`;
DROP table IF EXISTS `order_12`;
DROP table IF EXISTS `order_13`;
DROP table IF EXISTS `order_14`;
DROP table IF EXISTS `order_15`;

-- 订单1
CREATE TABLE `order_0`  (
     `id` BIGINT NOT NULL,
     `order_no` VARCHAR(255) NOT NULL,
     `status` VARCHAR(2) DEFAULT NULL,
     `user_id` BIGINT NOT NULL,
     `product_id` BIGINT NOT NULL,
     `worksite` VARCHAR(1000) DEFAULT NULL,
     `remark` VARCHAR(1000) DEFAULT NULL,
     `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     `update_time` TIMESTAMP NULL,
     `submit_time` TIMESTAMP NULL,
     PRIMARY KEY (`order_no`, `user_id`, `product_id`) USING BTREE
) ENGINE = InnoDB;

-- 订单2
CREATE TABLE `order_1`  (
     `id` BIGINT NOT NULL,
     `order_no` VARCHAR(255) NOT NULL,
     `status` VARCHAR(2) DEFAULT NULL,
     `user_id` BIGINT NOT NULL,
     `product_id` BIGINT NOT NULL,
     `worksite` VARCHAR(1000) DEFAULT NULL,
     `remark` VARCHAR(1000) DEFAULT NULL,
     `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     `update_time` TIMESTAMP NULL,
     `submit_time` TIMESTAMP NULL,
     PRIMARY KEY (`order_no`, `user_id`, `product_id`) USING BTREE
) ENGINE = InnoDB;

-- 订单3
CREATE TABLE `order_2`  (
     `id` BIGINT NOT NULL,
     `order_no` VARCHAR(255) NOT NULL,
     `status` VARCHAR(2) DEFAULT NULL,
     `user_id` BIGINT NOT NULL,
     `product_id` BIGINT NOT NULL,
     `worksite` VARCHAR(1000) DEFAULT NULL,
     `remark` VARCHAR(1000) DEFAULT NULL,
     `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     `update_time` TIMESTAMP NULL,
     `submit_time` TIMESTAMP NULL,
     PRIMARY KEY (`order_no`, `user_id`, `product_id`) USING BTREE
) ENGINE = InnoDB;

-- 订单4
CREATE TABLE `order_3`  (
    `id` BIGINT NOT NULL,
    `order_no` VARCHAR(255) NOT NULL,
    `status` VARCHAR(2) DEFAULT NULL,
    `user_id` BIGINT NOT NULL,
    `product_id` BIGINT NOT NULL,
    `worksite` VARCHAR(1000) DEFAULT NULL,
    `remark` VARCHAR(1000) DEFAULT NULL,
    `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `update_time` TIMESTAMP NULL,
    `submit_time` TIMESTAMP NULL,
    PRIMARY KEY (`order_no`, `user_id`, `product_id`) USING BTREE,
    CONSTRAINT UNIQUE(`order_no`,`user_id`,`product_id`)
) ENGINE = InnoDB;

-- 订单5
CREATE TABLE `order_4`  (
     `id` BIGINT NOT NULL,
     `order_no` VARCHAR(255) NOT NULL,
     `status` VARCHAR(2) DEFAULT NULL,
     `user_id` BIGINT NOT NULL,
     `product_id` BIGINT NOT NULL,
     `worksite` VARCHAR(1000) DEFAULT NULL,
     `remark` VARCHAR(1000) DEFAULT NULL,
     `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     `update_time` TIMESTAMP NULL,
     `submit_time` TIMESTAMP NULL,
     PRIMARY KEY (`order_no`, `user_id`, `product_id`) USING BTREE
) ENGINE = InnoDB;

-- 订单6
CREATE TABLE `order_5`  (
     `id` BIGINT NOT NULL,
     `order_no` VARCHAR(255) NOT NULL,
     `status` VARCHAR(2) DEFAULT NULL,
     `user_id` BIGINT NOT NULL,
     `product_id` BIGINT NOT NULL,
     `worksite` VARCHAR(1000) DEFAULT NULL,
     `remark` VARCHAR(1000) DEFAULT NULL,
     `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     `update_time` TIMESTAMP NULL,
     `submit_time` TIMESTAMP NULL,
     PRIMARY KEY (`order_no`, `user_id`, `product_id`) USING BTREE
) ENGINE = InnoDB;

-- 订单7
CREATE TABLE `order_6`  (
     `id` BIGINT NOT NULL,
     `order_no` VARCHAR(255) NOT NULL,
     `status` VARCHAR(2) DEFAULT NULL,
     `user_id` BIGINT NOT NULL,
     `product_id` BIGINT NOT NULL,
     `worksite` VARCHAR(1000) DEFAULT NULL,
     `remark` VARCHAR(1000) DEFAULT NULL,
     `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     `update_time` TIMESTAMP NULL,
     `submit_time` TIMESTAMP NULL,
     PRIMARY KEY (`order_no`, `user_id`, `product_id`) USING BTREE
) ENGINE = InnoDB;

-- 订单8
CREATE TABLE `order_7`  (
     `id` BIGINT NOT NULL,
     `order_no` VARCHAR(255) NOT NULL,
     `status` VARCHAR(2) DEFAULT NULL,
     `user_id` BIGINT NOT NULL,
     `product_id` BIGINT NOT NULL,
     `worksite` VARCHAR(1000) DEFAULT NULL,
     `remark` VARCHAR(1000) DEFAULT NULL,
     `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     `update_time` TIMESTAMP NULL,
     `submit_time` TIMESTAMP NULL,
     PRIMARY KEY (`order_no`, `user_id`, `product_id`) USING BTREE
) ENGINE = InnoDB;

-- 订单9
CREATE TABLE `order_8`  (
     `id` BIGINT NOT NULL,
     `order_no` VARCHAR(255) NOT NULL,
     `status` VARCHAR(2) DEFAULT NULL,
     `user_id` BIGINT NOT NULL,
     `product_id` BIGINT NOT NULL,
     `worksite` VARCHAR(1000) DEFAULT NULL,
     `remark` VARCHAR(1000) DEFAULT NULL,
     `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     `update_time` TIMESTAMP NULL,
     `submit_time` TIMESTAMP NULL,
     PRIMARY KEY (`order_no`, `user_id`, `product_id`) USING BTREE
) ENGINE = InnoDB;

-- 订单10
CREATE TABLE `order_9`  (
     `id` BIGINT NOT NULL,
     `order_no` VARCHAR(255) NOT NULL,
     `status` VARCHAR(2) DEFAULT NULL,
     `user_id` BIGINT NOT NULL,
     `product_id` BIGINT NOT NULL,
     `worksite` VARCHAR(1000) DEFAULT NULL,
     `remark` VARCHAR(1000) DEFAULT NULL,
     `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     `update_time` TIMESTAMP NULL,
     `submit_time` TIMESTAMP NULL,
     PRIMARY KEY (`order_no`, `user_id`, `product_id`) USING BTREE
) ENGINE = InnoDB;

-- 订单11
CREATE TABLE `order_10`  (
     `id` BIGINT NOT NULL,
     `order_no` VARCHAR(255) NOT NULL,
     `status` VARCHAR(2) DEFAULT NULL,
     `user_id` BIGINT NOT NULL,
     `product_id` BIGINT NOT NULL,
     `worksite` VARCHAR(1000) DEFAULT NULL,
     `remark` VARCHAR(1000) DEFAULT NULL,
     `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     `update_time` TIMESTAMP NULL,
     `submit_time` TIMESTAMP NULL,
     PRIMARY KEY (`order_no`, `user_id`, `product_id`) USING BTREE
) ENGINE = InnoDB;

-- 订单12
CREATE TABLE `order_11`  (
     `id` BIGINT NOT NULL,
     `order_no` VARCHAR(255) NOT NULL,
     `status` VARCHAR(2) DEFAULT NULL,
     `user_id` BIGINT NOT NULL,
     `product_id` BIGINT NOT NULL,
     `worksite` VARCHAR(1000) DEFAULT NULL,
     `remark` VARCHAR(1000) DEFAULT NULL,
     `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     `update_time` TIMESTAMP NULL,
     `submit_time` TIMESTAMP NULL,
     PRIMARY KEY (`order_no`, `user_id`, `product_id`) USING BTREE
) ENGINE = InnoDB;

-- 订单13
CREATE TABLE `order_12`  (
     `id` BIGINT NOT NULL,
     `order_no` VARCHAR(255) NOT NULL,
     `status` VARCHAR(2) DEFAULT NULL,
     `user_id` BIGINT NOT NULL,
     `product_id` BIGINT NOT NULL,
     `worksite` VARCHAR(1000) DEFAULT NULL,
     `remark` VARCHAR(1000) DEFAULT NULL,
     `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     `update_time` TIMESTAMP NULL,
     `submit_time` TIMESTAMP NULL,
     PRIMARY KEY (`order_no`, `user_id`, `product_id`) USING BTREE
) ENGINE = InnoDB;

-- 订单14
CREATE TABLE `order_13`  (
     `id` BIGINT NOT NULL,
     `order_no` VARCHAR(255) NOT NULL,
     `status` VARCHAR(2) DEFAULT NULL,
     `user_id` BIGINT NOT NULL,
     `product_id` BIGINT NOT NULL,
     `worksite` VARCHAR(1000) DEFAULT NULL,
     `remark` VARCHAR(1000) DEFAULT NULL,
     `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     `update_time` TIMESTAMP NULL,
     `submit_time` TIMESTAMP NULL,
     PRIMARY KEY (`order_no`, `user_id`, `product_id`) USING BTREE
) ENGINE = InnoDB;

-- 订单15
CREATE TABLE `order_14`  (
     `id` BIGINT NOT NULL,
     `order_no` VARCHAR(255) NOT NULL,
     `status` VARCHAR(2) DEFAULT NULL,
     `user_id` BIGINT NOT NULL,
     `product_id` BIGINT NOT NULL,
     `worksite` VARCHAR(1000) DEFAULT NULL,
     `remark` VARCHAR(1000) DEFAULT NULL,
     `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     `update_time` TIMESTAMP NULL,
     `submit_time` TIMESTAMP NULL,
     PRIMARY KEY (`order_no`, `user_id`, `product_id`) USING BTREE
) ENGINE = InnoDB;

-- 订单16
CREATE TABLE `order_15`  (
     `id` BIGINT NOT NULL,
     `order_no` VARCHAR(255) NOT NULL,
     `status` VARCHAR(2) DEFAULT NULL,
     `user_id` BIGINT NOT NULL,
     `product_id` BIGINT NOT NULL,
     `worksite` VARCHAR(1000) DEFAULT NULL,
     `remark` VARCHAR(1000) DEFAULT NULL,
     `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     `update_time` TIMESTAMP NULL,
     `submit_time` TIMESTAMP NULL,
     PRIMARY KEY (`order_no`, `user_id`, `product_id`) USING BTREE
) ENGINE = InnoDB;