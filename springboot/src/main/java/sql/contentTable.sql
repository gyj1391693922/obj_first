/**
  用户信息表
 */
CREATE TABLE `admin` (
                         `u_id` int NOT NULL AUTO_INCREMENT COMMENT '用户主键',
                         `u_username` varchar(50) NOT NULL COMMENT '用户名',
                         `u_password` varchar(25) NOT NULL COMMENT '用户密码',
                         `u_createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                         `u_name` varchar(50) NOT NULL COMMENT '用户真实姓名',
                         `u_idCard` varchar(20) NOT NULL COMMENT '用户身份证号码',
                         `u_address` varchar(255) NOT NULL COMMENT '用户住址',
                         `u_phone` varchar(11) NOT NULL COMMENT '用户手机号',
                         `u_money` bigint NOT NULL COMMENT '用户余额',
                         PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/**
  医生信息表
 */
CREATE TABLE `doctor` (
                          `d_id` int NOT NULL AUTO_INCREMENT COMMENT '医生id',
                          `d_name` varchar(50) NOT NULL COMMENT '医生姓名',
                          `d_phone` varchar(11) NOT NULL COMMENT '医生手机号',
                          `d_leve` varchar(50) NOT NULL COMMENT '医生职业等级',
                          `d_money` varchar(255) NOT NULL COMMENT '医生薪资(月)',
                          `d_educational` varchar(50) NOT NULL COMMENT '医生教育经历(取最高)',
                          `d_profession` varchar(50) NOT NULL COMMENT '医生专业方向',
                          `d_age` varchar(50) NOT NULL COMMENT '医生年龄',
                          `d_sex` varchar(2) NOT NULL COMMENT '医生性别',
                          `d_createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                          `d_uid` int NOT NULL COMMENT '身份识别号',
                          PRIMARY KEY (`d_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/**
  药品信息表
 */
CREATE TABLE `medicinal` (
                             `m_id` int NOT NULL AUTO_INCREMENT COMMENT '药品id',
                             `m_number` bigint NOT NULL COMMENT '药品编号',
                             `m_name` varchar(255) NOT NULL COMMENT '药品名',
                             `m_create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             `m_qty` int NOT NULL COMMENT '药品数量',
                             `m_content` varchar(50) NOT NULL COMMENT '净含量',
                             `m_price` decimal(10,2) NOT NULL COMMENT '价格',
                             PRIMARY KEY (`m_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/**
  药单表
 */
CREATE TABLE `receipt` (
                           `id` int NOT NULL COMMENT '药单id',
                           `m_name` varchar(30) NOT NULL COMMENT '药品名',
                           `m_number` bigint NOT NULL COMMENT '药品编号',
                           `u_name` varchar(255) NOT NULL COMMENT '购买用户姓名',
                           `m_amount` varchar(255) NOT NULL COMMENT '购买总金额',
                           `u_phone` varchar(255) NOT NULL COMMENT '购买用户手机号',
                           `r_createtime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
                           `r_number` int NOT NULL COMMENT '购买数量',
                           `r_comment` text NOT NULL COMMENT '备注',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/**
  患者表
 */

CREATE TABLE `user` (
                        `id` int NOT NULL COMMENT '患者id',
                        `name` varchar(50) NOT NULL COMMENT '患者真实姓名',
                        `age` int NOT NULL COMMENT '患者年龄',
                        `sex` varchar(2) NOT NULL COMMENT '患者性别',
                        `phone` varchar(11) NOT NULL COMMENT '患者手机号',
                        `status` varchar(255) NOT NULL COMMENT '患者状态',
                        `ward` varchar(255) NOT NULL COMMENT '病房号',
                        `idCard` varchar(255) NOT NULL COMMENT '患者唯一识别号',
                        `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                        `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;