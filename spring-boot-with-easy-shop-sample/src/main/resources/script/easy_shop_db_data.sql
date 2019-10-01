-- 导入测试商品列表
insert into T_PRODUCT (ID,PRODUCT_NAME, COVER_IMAGE, PRODUCT_PRICE) values(1,'测试商品-001', '/products/cover/001.png', 100);
insert into T_PRODUCT (ID,PRODUCT_NAME, COVER_IMAGE, PRODUCT_PRICE) values(2,'测试商品-002', '/products/cover/002.png', 200);
insert into T_PRODUCT (ID,PRODUCT_NAME, COVER_IMAGE, PRODUCT_PRICE) values(3,'测试商品-003', '/products/cover/003.png', 300);
insert into T_PRODUCT (ID,PRODUCT_NAME, COVER_IMAGE, PRODUCT_PRICE) values(4,'测试商品-004', '/products/cover/004.png', 400);
insert into T_PRODUCT (ID,PRODUCT_NAME, COVER_IMAGE, PRODUCT_PRICE) values(5,'测试商品-005', '/products/cover/005.png', 500);
-- 导入测试用户列表
insert into T_USER_INFO (ID,NICK_NAME,AVATAR) values(1,'zhangSan', '/users/avatar/zhangsan.png');
insert into T_USER_INFO (ID,NICK_NAME,AVATAR) values(2,'lisi', '/users/avatar/lisi.png');
insert into T_USER_INFO (ID,NICK_NAME,AVATAR) values(3,'wangwu', '/users/avatar/wangwu.png');
insert into T_USER_INFO (ID,NICK_NAME,AVATAR) values(4,'maliu', '/users/avatar/maliu.png');
-- 导入商品3的评论列表
insert into T_PRODUCT_COMMENT (ID,PRODUCT_ID, AUTHOR_ID, CONTENT, CREATED) values(1,3, 1, '非常不错的商品', CURRENT_TIMESTAMP());
insert into T_PRODUCT_COMMENT (ID,PRODUCT_ID, AUTHOR_ID, CONTENT, CREATED) values(2,3, 3, '非常不错的商品+1', CURRENT_TIMESTAMP());
insert into T_PRODUCT_COMMENT (ID,PRODUCT_ID, AUTHOR_ID, CONTENT, CREATED) values(3,3, 4, '哈哈，谁用谁知道', CURRENT_TIMESTAMP());