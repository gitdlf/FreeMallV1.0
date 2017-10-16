--����freemall�û�����Ϊfreemall
create user freemall identified by freemall;

--Ϊfreemall�û�����connect��resourceȨ��
grant connect,resource to freemall;

--Ϊfreemall�û�����create viewȨ��
grant create view to freemall;

--�����û���
create table users_t(
       userId number primary key,--�û�id
       userName varchar2(20) unique not null, --�û���
       userPwd varchar2(20) not null,--�û�����
       userSex varchar2(10) check (userSex  in ('male','female')),--�û��Ա�
       userBirth date,--�û�����
       userPhone varchar2(11),--�û��绰
       userIdCare varchar2(18),--�û����֤
       userEmail varchar2(50),--�û�����
       userAddress varchar2(100),--�û��ջ���ַ
       createAuthor varchar2(20),
       createDate date default sysdate,
       modifyAuthor varchar2(20),
       modifyDate date 
);

--�����û�����
create sequence users_s;


--�����������Ѹ��ģ������ջ���ַ
create table order_t(
       orderId number primary key,--��������
       orderNo varchar(20),--�������uuid
       statusName number check (statusName in(0,1,2,3,4,5)),--����״̬
       userId number,--�û�id
	   address varchar(500),--�ջ���ַ
       createAuthor varchar2(20),--�����ߣ�Ҳ�Ͷ��������û�������
       createDate date default sysdate,
       modifyAuthor varchar2(20),
       modifyDate date 
);

--������������
create sequence order_s;


--������Ʒ��
--�޸���Ʒ����������ֶ�salenum
create table goods_t(
       goodsId number primary key,--��Ʒid
       price number,--��Ʒ�۸�
       introduce varchar2(500),--��Ʒ����
       goodsName varchar2(500),--��Ʒ�۸�
       imageAddress varchar2(500),--��ƷͼƬ��ַ
	   stack number default 0,--��Ʒ���
       childCateId number,--�����
	   parentCateId number,--�����
	   saleNum number,--��������
       createAuthor varchar2(20),
       createDate date default sysdate,
       modifyAuthor varchar2(20),
       modifyDate date 
);

--������Ʒ����
create sequence goods_s;


--����������
create table parentCate_t(
       parentCateId number primary key,--�����id
       parentCateName varchar2(20),--���������
       createAuthor varchar2(20),
       createDate date default sysdate,
       modifyAuthor varchar2(20),
       modifyDate date 
);
--�������������
create sequence parentCate_s;



--����������
create table childCate_t(
       childCateId number primary key,--�����id
       childCateName varchar2(20),--���������
       parentCateId number,--�����id
       createAuthor varchar2(20),
       createDate date default sysdate,
       modifyAuthor varchar2(20),
       modifyDate date 
);

--�������������
create sequence childCate_s;

--����������Ϣ��
create table message_t(
       messageId number primary key,--����id
       content varchar2(200),--��������
       userId number not null,--�û�id
       goodsId number not null,--��Ʒid
	   userState number check (userState in (1,2,3,4,5,0)),--�û����ۼ���
       createAuthor varchar2(20),
       createDate date default sysdate,
       modifyAuthor varchar2(20),
       modifyDate date 
);
--�����������ۼ���id
alter table message_t modify userState number default 0;

--������������
create sequence message_s;


--�������
create table activite_t(
(
		activiteid  NUMBER not null,--�id
		activiteno  VARCHAR2(50),--����
		proid  NUMBER,--��Ʒid
		activitename  VARCHAR2(500),--�����
		backgroundimagesaddress VARCHAR2(300),--�����ͼƬ
        createAuthor varchar2(20),
		createDate date default sysdate,
		modifyAuthor varchar2(20),
		modifyDaate date
);


--�����
create sequence activity_s;





   
 --�¼ӱ�
 
--������ҳ��𵼺�����id������id����ҳ��Ʒid
create table indexcatenav_t(
       indexId number primary key,--��ҳ���id������Ϊ��������
       parentCateId number,--�����id
       indexProId number,--��ҳ��Ʒid
	   createAuthor varchar2(20),
       createDate date default sysdate,
       modifyAuthor varchar(20),
       modifyDate date 
)

--��������
create sequence indexcatenav_s

--������ҳ��𵼺���ͼ//parentCateId�����id��parentcatename�������
create view indexcatenav_view (parentCateId,parentCateName,indexProId) as select s1.parentCateId,s2.parentcatename,s1.indexProId from indexcatenav_t s1,Parentcate_t s2 where s1.parentcateid=s2.parentcateid;


--������ҳ���ർ������������Ʒ��
create table indexcatepro_t(
       indexId number primary key,--��ҳ������Ʒid������Ϊ����
       parentCateId number,--�����id
       goodsId number,--��Ʒid
       createAuthor varchar(20),
       createDate date default sysdate,
       modifyAuthor varchar(20),
       modifyDate date 
)

--��������
create sequence indexcatepro_s;

--������ҳ���ർ������������Ʒ�����ͼ
create view indexcatepro_view as select s1.* from goods_t s1,indexcatepro_t s2 where s2.goodsid=s1.goodsid;






--�������ﳵ��
--���ﳵ������id
--���ﳵ������no
--���ﳵ�����ﳵ��״̬0,1
--0��ʾɾ����1��ʾ����Ĭ��ֵΪ1

create table cart_t(
       cartid number primary key,  --���ﳵ����
       proName varchar2(500), --��Ʒ����
       proPrice number, --��Ʒ�۸�
       proCount number, --��Ʒ����
       userid number, --�û�id
       orderid number, --����id
       proId number, --��Ʒid
	   cartstate number  default 1, --���ﳵ״̬
	   orderNo varchar2(50),--�������
       createAuthor varchar2(20),
       createDate date default sysdate,
       modifyAuthor varchar2(20),
       modifyDaate date
)
--Ϊ���ﳵ״̬���Լ��
alter table cart_t modify cartstate number check (cartstate in(0,1));

--�������ﳵ����
create sequence cart_s;

--���ﳵ��ʾ��ͼ
create view cart_item_view (cartid,proname,proprice,procount,userid,orderno,proid,imgAddress) as (select s1.cartid,s1.proname,s1.proprice,s1.procount,s1.userid,s1.orderno,s1.proid,s2.imageaddress from cart_t s1,goods_t s2 where s1.proid=s2.goodsid)








