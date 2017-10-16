--创建freemall用户密码为freemall
create user freemall identified by freemall;

--为freemall用户分配connect和resource权限
grant connect,resource to freemall;

--为freemall用户分配create view权限
grant create view to freemall;

--创建用户表
create table users_t(
       userId number primary key,--用户id
       userName varchar2(20) unique not null, --用户名
       userPwd varchar2(20) not null,--用户密码
       userSex varchar2(10) check (userSex  in ('male','female')),--用户性别
       userBirth date,--用户生日
       userPhone varchar2(11),--用户电话
       userIdCare varchar2(18),--用户身份证
       userEmail varchar2(50),--用户邮箱
       userAddress varchar2(100),--用户收货地址
       createAuthor varchar2(20),
       createDate date default sysdate,
       modifyAuthor varchar2(20),
       modifyDate date 
);

--创建用户序列
create sequence users_s;


--创建订单表，已更改，新增收货地址
create table order_t(
       orderId number primary key,--订单主键
       orderNo varchar(20),--订单编号uuid
       statusName number check (statusName in(0,1,2,3,4,5)),--订单状态
       userId number,--用户id
	   address varchar(500),--收货地址
       createAuthor varchar2(20),--创建者，也就订单所有用户的名字
       createDate date default sysdate,
       modifyAuthor varchar2(20),
       modifyDate date 
);

--创建订单序列
create sequence order_s;


--创建商品表
--修改商品表，添加销量字段salenum
create table goods_t(
       goodsId number primary key,--商品id
       price number,--商品价格
       introduce varchar2(500),--商品描述
       goodsName varchar2(500),--商品价格
       imageAddress varchar2(500),--商品图片地址
	   stack number default 0,--商品库存
       childCateId number,--子类别
	   parentCateId number,--父类别
	   saleNum number,--销售数量
       createAuthor varchar2(20),
       createDate date default sysdate,
       modifyAuthor varchar2(20),
       modifyDate date 
);

--创建商品序列
create sequence goods_s;


--创建父类别表
create table parentCate_t(
       parentCateId number primary key,--父类别id
       parentCateName varchar2(20),--父类别名称
       createAuthor varchar2(20),
       createDate date default sysdate,
       modifyAuthor varchar2(20),
       modifyDate date 
);
--创建父类别序列
create sequence parentCate_s;



--创建子类别表
create table childCate_t(
       childCateId number primary key,--子类别id
       childCateName varchar2(20),--子类别名称
       parentCateId number,--父类别id
       createAuthor varchar2(20),
       createDate date default sysdate,
       modifyAuthor varchar2(20),
       modifyDate date 
);

--创建子类别序列
create sequence childCate_s;

--创建留言信息表
create table message_t(
       messageId number primary key,--留言id
       content varchar2(200),--留言内容
       userId number not null,--用户id
       goodsId number not null,--商品id
	   userState number check (userState in (1,2,3,4,5,0)),--用户评论级别
       createAuthor varchar2(20),
       createDate date default sysdate,
       modifyAuthor varchar2(20),
       modifyDate date 
);
--增加留言评论级别id
alter table message_t modify userState number default 0;

--创建留言序列
create sequence message_s;


--创建活动表
create table activite_t(
(
		activiteid  NUMBER not null,--活动id
		activiteno  VARCHAR2(50),--活动编号
		proid  NUMBER,--商品id
		activitename  VARCHAR2(500),--活动名称
		backgroundimagesaddress VARCHAR2(300),--活动背景图片
        createAuthor varchar2(20),
		createDate date default sysdate,
		modifyAuthor varchar2(20),
		modifyDaate date
);


--活动序列
create sequence activity_s;





   
 --新加表
 
--创建主页类别导航表，表id，父类id，主页商品id
create table indexcatenav_t(
       indexId number primary key,--主页类别id，仅仅为主键而已
       parentCateId number,--父类别id
       indexProId number,--主页商品id
	   createAuthor varchar2(20),
       createDate date default sysdate,
       modifyAuthor varchar(20),
       modifyDate date 
)

--创建序列
create sequence indexcatenav_s

--创建主页类别导航视图//parentCateId，类别id，parentcatename类别名称
create view indexcatenav_view (parentCateId,parentCateName,indexProId) as select s1.parentCateId,s2.parentcatename,s1.indexProId from indexcatenav_t s1,Parentcate_t s2 where s1.parentcateid=s2.parentcateid;


--创建主页分类导航两个特征商品表
create table indexcatepro_t(
       indexId number primary key,--主页特征商品id，仅仅为主键
       parentCateId number,--父类别id
       goodsId number,--商品id
       createAuthor varchar(20),
       createDate date default sysdate,
       modifyAuthor varchar(20),
       modifyDate date 
)

--创建索引
create sequence indexcatepro_s;

--创建主页分类导航两个特征商品表的视图
create view indexcatepro_view as select s1.* from goods_t s1,indexcatepro_t s2 where s2.goodsid=s1.goodsid;






--新增购物车表
--购物车表，订单id
--购物车表，订单no
--购物车表，购物车项状态0,1
--0表示删除，1表示存在默认值为1

create table cart_t(
       cartid number primary key,  --购物车主键
       proName varchar2(500), --商品名字
       proPrice number, --商品价格
       proCount number, --商品数量
       userid number, --用户id
       orderid number, --订单id
       proId number, --商品id
	   cartstate number  default 1, --购物车状态
	   orderNo varchar2(50),--订单编号
       createAuthor varchar2(20),
       createDate date default sysdate,
       modifyAuthor varchar2(20),
       modifyDaate date
)
--为购物车状态添加约束
alter table cart_t modify cartstate number check (cartstate in(0,1));

--创建购物车序列
create sequence cart_s;

--购物车显示视图
create view cart_item_view (cartid,proname,proprice,procount,userid,orderno,proid,imgAddress) as (select s1.cartid,s1.proname,s1.proprice,s1.procount,s1.userid,s1.orderno,s1.proid,s2.imageaddress from cart_t s1,goods_t s2 where s1.proid=s2.goodsid)








