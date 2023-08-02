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