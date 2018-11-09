drop table tb_notice;

CREATE TABLE tb_notice (
   nno NUMBER(5) NOT NULL, /* ������ȣ */
   title VARCHAR2(50), /* ���� */
   cont VARCHAR2(2000), /* ���� */
   regdt VARCHAR2(20) not null /* ������� */
 	
);

select * from tb_notice order by nno;
CREATE UNIQUE INDEX PK_tb_notice
   ON tb_notice (
      nno ASC
   );

ALTER TABLE tb_notice
   ADD
      CONSTRAINT PK_tb_notice
      PRIMARY KEY (
         nno
      );
      
      create sequence notice_seq;
		drop sequence notice_seq;

commit;

select * from tb_notice;

insert into tb_notice(nno,title,cont,regdt) values(notice_seq.nextval,'11�� �̺�Ʈ!','���� �Һ� ���Ž� ����ǰ�� 20%�� ����!!',sysdate);
 
/* ���� */
DROP TABLE tb_user 
	CASCADE CONSTRAINTS;

/* QnA �Խ��� */
DROP TABLE tb_qna 
	CASCADE CONSTRAINTS;

/* �������� */
DROP TABLE tb_notice 
	CASCADE CONSTRAINTS;

/* ��ٱ��� */
DROP TABLE tb_basket 
	CASCADE CONSTRAINTS;

/* ��ǰ����Ʈ */
DROP TABLE tb_product 
	CASCADE CONSTRAINTS;

/* �ֹ� */
DROP TABLE tb_order 
	CASCADE CONSTRAINTS;

/* ��� */
DROP TABLE tb_delivery 
	CASCADE CONSTRAINTS;

/* �ֹ��� */
DROP TABLE tb_detail 
	CASCADE CONSTRAINTS;

/* ���� */
CREATE TABLE tb_user (
	userid VARCHAR2(20) NOT NULL, /* �������̵� */
	name VARCHAR2(20), /* �̸� */
	pwd VARCHAR2(255), /* ��й�ȣ */
	birth VARCHAR2(255), /* ������� */
	phone VARCHAR2(255), /* �޴�����ȣ */
	addr VARCHAR2(255), /* �ּ� */
	email VARCHAR2(255), /* �̸����ּ� */
	manger NUMBER(3), /* ������ */
	flag NUMBER(3), /* ȸ��Ż�� */
	regdt DATE /* ������ */
);

CREATE UNIQUE INDEX PK_tb_user
	ON tb_user (
		userid ASC
	);

ALTER TABLE tb_user
	ADD
		CONSTRAINT PK_tb_user
		PRIMARY KEY (
			userid
		);

/* QnA �Խ��� */
CREATE TABLE tb_qna (
	qno NUMBER(5) NOT NULL, /* �Խ��ǹ�ȣ */
	title VARCHAR2(50), /* ���� */
	content VARCHAR2(2000), /* ���� */
	pwd VARCHAR2(255), /* ��й�ȣ */
	regdt DATE, /* ��Ͻð� */
	photo VARCHAR2(255), /* ���� */
	mflag NUMBER(3), /* ����_������üũ */
	userid VARCHAR2(20), /* �������̵� */
	qno2 NUMBER(5) /* �Խ��ǹ�ȣ-��� */
);

CREATE UNIQUE INDEX PK_tb_qna
	ON tb_qna (
		qno ASC
	);

ALTER TABLE tb_qna
	ADD
		CONSTRAINT PK_tb_qna
		PRIMARY KEY (
			qno
		);

/* �������� */
CREATE TABLE tb_notice (
	nno NUMBER(5) NOT NULL, /* ��ȣ */
	title VARCHAR2(50), /* ���� */
	content VARCHAR2(2000), /* ���� */
	regdt DATE /* �ۼ��� */
);

CREATE UNIQUE INDEX PK_tb_notice
	ON tb_notice (
		nno ASC
	);

ALTER TABLE tb_notice
	ADD
		CONSTRAINT PK_tb_notice
		PRIMARY KEY (
			nno
		);

/* ��ٱ��� */
CREATE TABLE tb_basket (
	bno NUMBER(5) NOT NULL, /* ��ٱ��Ϲ�ȣ */
	pno NUMBER(5), /* ��ǰ��ȣ */
	userid VARCHAR2(20), /* �������̵� */
	b_option VARCHAR2(255), /* �ɼ� */
	amount NUMBER(3), /* ���� */
	price NUMBER(10) /* �Ѱ��� */
);

CREATE UNIQUE INDEX PK_tb_basket
	ON tb_basket (
		bno ASC
	);

ALTER TABLE tb_basket
	ADD
		CONSTRAINT PK_tb_basket
		PRIMARY KEY (
			bno
		);

/* ��ǰ����Ʈ */
CREATE TABLE tb_product (
	pno NUMBER(5) NOT NULL, /* ��ǰ��ȣ */
	pname VARCHAR2(255), /* ��ǰ�̸� */
	info VARCHAR2(255), /* ��ǰ���� */
	price NUMBER(10), /* ��ǰ���� */
	category VARCHAR2(40), /* ī�װ� */
	photo VARCHAR2(255), /* ���� */
	brand VARCHAR2(255), /* �귣�� */
	stock NUMBER(3), /* ��� */
	regdt DATE /* ����� */
);

CREATE UNIQUE INDEX PK_tb_product
	ON tb_product (
		pno ASC
	);

ALTER TABLE tb_product
	ADD
		CONSTRAINT PK_tb_product
		PRIMARY KEY (
			pno
		);

/* �ֹ� */
CREATE TABLE tb_order (
	ono NUMBER(5) NOT NULL, /* �ֹ���ȣ */
	userid VARCHAR2(20), /* �������̵� */
	paydt DATE, /* �������� */
	payment NUMBER(10), /* �����ݾ� */
	other VARCHAR2(255) /* ��Ÿ���� */
);

CREATE UNIQUE INDEX PK_tb_order
	ON tb_order (
		ono ASC
	);

ALTER TABLE tb_order
	ADD
		CONSTRAINT PK_tb_order
		PRIMARY KEY (
			ono
		);

/* ��� */
CREATE TABLE tb_delivery (
	dno NUMBER(5) NOT NULL, /* ��۹�ȣ */
	company VARCHAR2(20), /* �ù�ȸ�� */
	shipnum VARCHAR2(255), /* �����ȣ */
	addr VARCHAR2(255), /* ������ּ� */
	phone VARCHAR2(255), /* �����ȭ��ȣ */
	startdate DATE, /* ���������� */
	ono NUMBER(5), /* �ֹ���ȣ */
	status NUMBER(3) /* ��ۻ��� */
);





CREATE UNIQUE INDEX PK_tb_delivery
	ON tb_delivery (
		dno ASC
	);

ALTER TABLE tb_delivery
	ADD
		CONSTRAINT PK_tb_delivery
		PRIMARY KEY (
			dno
		);

/* �ֹ��� */
CREATE TABLE tb_detail (
	dno NUMBER(5) NOT NULL, /* �ֹ��󼼹�ȣ */
	ono NUMBER(5) NOT NULL, /* �ֹ���ȣ */
	pno NUMBER(5) NOT NULL, /* ��ǰ��ȣ */
	price NUMBER(10), /* �ֹ����� */
	amount NUMBER(3), /* ���� */
	d_option VARCHAR2(255), /* �ɼ� */
	orderdt DATE /* �ֹ����� */
);

CREATE UNIQUE INDEX PK_tb_detail
	ON tb_detail (
		dno ASC,
		ono ASC
	);

ALTER TABLE tb_detail
	ADD
		CONSTRAINT PK_tb_detail
		PRIMARY KEY (
			dno,
			ono
		);

ALTER TABLE tb_qna
	ADD
		CONSTRAINT FK_tb_user_TO_tb_qna
		FOREIGN KEY (
			userid
		)
		REFERENCES tb_user (
			userid
		);

ALTER TABLE tb_qna
	ADD
		CONSTRAINT FK_tb_qna_TO_tb_qna
		FOREIGN KEY (
			qno2
		)
		REFERENCES tb_qna (
			qno
		);

ALTER TABLE tb_basket
	ADD
		CONSTRAINT FK_tb_user_TO_tb_basket
		FOREIGN KEY (
			userid
		)
		REFERENCES tb_user (
			userid
		);

ALTER TABLE tb_basket
	ADD
		CONSTRAINT FK_tb_product_TO_tb_basket
		FOREIGN KEY (
			pno
		)
		REFERENCES tb_product (
			pno
		);

ALTER TABLE tb_order
	ADD
		CONSTRAINT FK_tb_user_TO_tb_order
		FOREIGN KEY (
			userid
		)
		REFERENCES tb_user (
			userid
		);

ALTER TABLE tb_delivery
	ADD
		CONSTRAINT FK_tb_order_TO_tb_delivery
		FOREIGN KEY (
			ono
		)
		REFERENCES tb_order (
			ono
		);

ALTER TABLE tb_detail
	ADD
		CONSTRAINT FK_tb_product_TO_tb_detail
		FOREIGN KEY (
			pno
		)
		REFERENCES tb_product (
			pno
		);

ALTER TABLE tb_detail
	ADD
		CONSTRAINT FK_tb_order_TO_tb_detail
		FOREIGN KEY (
			ono
		)
		REFERENCES tb_order (
			ono
		);
drop sequence product_seq
drop sequence notice_seq
drop sequence basket_seq
drop sequence order_seq
drop sequence detail_seq
drop sequence qna_seq
drop sequence delivery_seq

create sequence product_seq
create sequence notice_seq
create sequence basket_seq
create sequence order_seq
create sequence detail_seq
create sequence qna_seq
create sequence delivery_seq

insert into tb_product values(1001,'kosta1','��ǰ�����Դϴ�',100,'�Һ�','1.jpg','js',100,sysdate);
insert into tb_product values(1002,'kosta2','��ǰ�����Դϴ�',200,'�Һ�','2.jpg','js',200,sysdate);
insert into tb_product values(1003,'kosta3','��ǰ�����Դϴ�',300,'�Һ�','3.jpg','js',300,sysdate);
insert into tb_product values(1004,'kosta4','��ǰ�����Դϴ�',400,'�Һ�','4.jpg','js',400,sysdate);
insert into tb_product values(1005,'kosta5','��ǰ�����Դϴ�',500,'�Һ�','5.jpg','js',500,sysdate);

select * from  tb_product;
insert into tb_basket values(basket_seq.nextval, 1001,'test1','test-option1',3,3000);
insert into tb_basket values(basket_seq.nextval, 1002,'test1','test-option1',4,4000);
insert into tb_basket values(basket_seq.nextval, 1003,'test2','test-option1',2,2000);
insert into tb_basket values(basket_seq.nextval, 1003,'test2','test-option1',3,3000);
insert into tb_basket values(basket_seq.nextval, 1001,'test1','test-option1',1,1000);
select * from tb_basket;