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