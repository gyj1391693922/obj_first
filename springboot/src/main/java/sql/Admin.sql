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