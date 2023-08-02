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