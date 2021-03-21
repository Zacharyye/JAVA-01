DROP table IF EXISTS `order_a`;
DROP table IF EXISTS `order_b`;
DROP table IF EXISTS `order_c`;
DROP table IF EXISTS `order_d`;
DROP table IF EXISTS `order_e`;
DROP table IF EXISTS `order_f`;
DROP table IF EXISTS `order_g`;
DROP table IF EXISTS `order_h`;
DROP table IF EXISTS `order_i`;
DROP table IF EXISTS `order_j`;
DROP table IF EXISTS `order_k`;
DROP table IF EXISTS `order_l`;
DROP table IF EXISTS `order_m`;
DROP table IF EXISTS `order_n`;
DROP table IF EXISTS `order_o`;
DROP table IF EXISTS `order_p`;

-- 订单1
CREATE TABLE `order_a`  (
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
CREATE TABLE `order_b`  (
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
CREATE TABLE `order_c`  (
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
CREATE TABLE `order_d`  (
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
CREATE TABLE `order_e`  (
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
CREATE TABLE `order_f`  (
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
CREATE TABLE `order_g`  (
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
CREATE TABLE `order_h`  (
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
CREATE TABLE `order_i`  (
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
CREATE TABLE `order_j`  (
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
CREATE TABLE `order_k`  (
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
CREATE TABLE `order_l`  (
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
CREATE TABLE `order_m`  (
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
CREATE TABLE `order_n`  (
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
CREATE TABLE `order_o`  (
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
CREATE TABLE `order_p`  (
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