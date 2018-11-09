select * from product;

--��ǰ ���̺� ����
drop table product;

--��ǰ ���̺� ����
create table product(
	no int primary key,				--��ǰ����
	title varchar2(100) not null,	--��ǰ��
	content varchar2(50),			--��ǰ����
	regDate varchar2(20) not null,	--ī�װ�
	reg_pwd date not null,			--�������
	photo varchar2(20)				--����
)

select * from product;

--���ڵ� �߰�
insert into product(no,title,content,regDate,reg_pwd,photo) 
values('1','SS DW ����� ��Ʈ ���� �Һ� 473ml','���θ�� ��ǰ','��Ÿ����',sysdate,'����~');
insert into product(no,title,content,regDate,reg_pwd,photo) 
values('2','SS DW Ȧ������ �׷��� ���� �Һ� 473ml','���θ�� ��ǰ','��Ÿ����',sysdate,'����~');
insert into product(no,title,content,regDate,reg_pwd,photo) 
values('3','SS ��Ÿ ����Ʈ �� �Һ� 355ml','���θ�� ��ǰ','��Ÿ����',sysdate,'����~');

commit


---------------------�ٽ�------------------
drop table product;

create table product(
	productNum int primary key,				--��ǰ��ȣ
	productName varchar2(100) not null,	--��ǰ��
	productInfo varchar2(50),			--��ǰ����
	productPrice int not null,				--����
	productCatergory varchar2(30) not null,	--ī�װ�
	productBrand varchar2(20)				--�귣��
	productPhoto varchar2(20)				--����
)

select * from product;



insert into product(productNum,productName,productInfo,productPrice,productCatergory,productBrand)
values('1','SS DW ����� ��Ʈ ���� �Һ� 473ml','���θ�� ��ǰ','45500','�����θ��� �Һ�','��Ÿ����');
insert into product(productNum,productName,productInfo,productPrice,productCatergory,productBrand)
values('2','�Ƚ÷��� ���ͺ� �Һ� 355ml','���θ�� ��ǰ','39500','�ö�ƽ �Һ�','��Ÿ����');
insert into product(productNum,productName,productInfo,productPrice,productCatergory,productBrand)
values('3','SS ��Ÿ ����Ʈ �� �Һ� 355ml','���θ�� ��ǰ','55500','�����θ��� �Һ�','��Ÿ����');

commit

-----------------------------------------------------

insert into product(no,title,content,price,regDate,brand)
values('1','SS DW ����� ��Ʈ ���� �Һ� 473ml','���θ�� ��ǰ','45500','�����θ��� �Һ�','��Ÿ����');
insert into product(no,title,content,price,regDate,brand)
values('2','�Ƚ÷��� ���ͺ� �Һ� 355ml','���θ�� ��ǰ','39500','�ö�ƽ �Һ�','��Ÿ����');
insert into product(no,title,content,price,regDate,brand)
values('3','SS ��Ÿ ����Ʈ �� �Һ� 355ml','���θ�� ��ǰ','55500','�����θ��� �Һ�','��Ÿ����');

commit

-------------------------------------------------------------
drop table product;

create table product(
	pno int primary key,			--��ǰ��ȣ
	pname varchar2(100) not null,	--��ǰ�̸�
	info varchar2(255),				--��ǰ����
	price int not null,				--��ǰ����
	category varchar2(40) not null,	--ī�װ�
	photo varchar2(255),			--����
	brand varchar2(255),			--�귣��
	stock int not null,				--���
	regdt date not null				--�����
)


insert into product(pno,pname,info,price,category,photo,brand,stock,regdt)
values('1','SS DW ����� ��Ʈ ���� �Һ� 473ml','���θ�� ��ǰ','45500','�����θ���','����~','��Ÿ����',100,sysdate);
insert into product(pno,pname,info,price,category,photo,brand,stock,regdt)
values('2','�Ƚ÷��� ���ͺ� �Һ� 355ml','���θ�� ��ǰ','39500','�ö�ƽ','����~','��Ÿ����',200,sysdate);
insert into product(pno,pname,info,price,category,photo,brand,stock,regdt)
values('3','SS ��Ÿ ����Ʈ �� �Һ� 355ml','���θ�� ��ǰ','55500','�����θ���','����~','��Ÿ����',150,sysdate);
 
commit

select * from product;

select * from product where pno=1;

update product set pname='���ξ�',info='�����',price=123,category='�ö�ƽ',brand='����',stock=56 where pno=2;

