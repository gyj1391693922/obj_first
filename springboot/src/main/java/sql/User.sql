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