drop table tb_notice;

CREATE TABLE tb_notice (
   nno NUMBER(5) NOT NULL, /* 공지번호 */
   title VARCHAR2(50), /* 제목 */
   cont VARCHAR2(2000), /* 내용 */
   regdt VARCHAR2(20) not null /* 등록일자 */
 	
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

insert into tb_notice(nno,title,cont,regdt) values(notice_seq.nextval,'11월 이벤트!','시즌 텀블러 구매시 구매품에 20%로 할인!!',sysdate);
 
/* 유저 */
DROP TABLE tb_user 
	CASCADE CONSTRAINTS;

/* QnA 게시판 */
DROP TABLE tb_qna 
	CASCADE CONSTRAINTS;

/* 공지사항 */
DROP TABLE tb_notice 
	CASCADE CONSTRAINTS;

/* 장바구니 */
DROP TABLE tb_basket 
	CASCADE CONSTRAINTS;

/* 상품리스트 */
DROP TABLE tb_product 
	CASCADE CONSTRAINTS;

/* 주문 */
DROP TABLE tb_order 
	CASCADE CONSTRAINTS;

/* 배송 */
DROP TABLE tb_delivery 
	CASCADE CONSTRAINTS;

/* 주문상세 */
DROP TABLE tb_detail 
	CASCADE CONSTRAINTS;

/* 유저 */
CREATE TABLE tb_user (
	userid VARCHAR2(20) NOT NULL, /* 유저아이디 */
	name VARCHAR2(20), /* 이름 */
	pwd VARCHAR2(255), /* 비밀번호 */
	birth VARCHAR2(255), /* 생년월일 */
	phone VARCHAR2(255), /* 휴대폰번호 */
	addr VARCHAR2(255), /* 주소 */
	email VARCHAR2(255), /* 이메일주소 */
	manger NUMBER(3), /* 관리자 */
	flag NUMBER(3), /* 회원탈퇴 */
	regdt DATE /* 가입일 */
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

/* QnA 게시판 */
CREATE TABLE tb_qna (
	qno NUMBER(5) NOT NULL, /* 게시판번호 */
	title VARCHAR2(50), /* 제목 */
	content VARCHAR2(2000), /* 내용 */
	pwd VARCHAR2(255), /* 비밀번호 */
	regdt DATE, /* 등록시간 */
	photo VARCHAR2(255), /* 사진 */
	mflag NUMBER(3), /* 유저_관리자체크 */
	userid VARCHAR2(20), /* 유저아이디 */
	qno2 NUMBER(5) /* 게시판번호-댓글 */
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

/* 공지사항 */
CREATE TABLE tb_notice (
	nno NUMBER(5) NOT NULL, /* 번호 */
	title VARCHAR2(50), /* 제목 */
	content VARCHAR2(2000), /* 내용 */
	regdt DATE /* 작성일 */
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

/* 장바구니 */
CREATE TABLE tb_basket (
	bno NUMBER(5) NOT NULL, /* 장바구니번호 */
	pno NUMBER(5), /* 상품번호 */
	userid VARCHAR2(20), /* 유저아이디 */
	b_option VARCHAR2(255), /* 옵션 */
	amount NUMBER(3), /* 수량 */
	price NUMBER(10) /* 총가격 */
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

/* 상품리스트 */
CREATE TABLE tb_product (
	pno NUMBER(5) NOT NULL, /* 상품번호 */
	pname VARCHAR2(255), /* 상품이름 */
	info VARCHAR2(255), /* 상품정보 */
	price NUMBER(10), /* 상품가격 */
	category VARCHAR2(40), /* 카테고리 */
	photo VARCHAR2(255), /* 사진 */
	brand VARCHAR2(255), /* 브랜드 */
	stock NUMBER(3), /* 재고량 */
	regdt DATE /* 등록일 */
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

/* 주문 */
CREATE TABLE tb_order (
	ono NUMBER(5) NOT NULL, /* 주문번호 */
	userid VARCHAR2(20), /* 유저아이디 */
	paydt DATE, /* 결제일자 */
	payment NUMBER(10), /* 결제금액 */
	other VARCHAR2(255) /* 기타사항 */
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

/* 배송 */
CREATE TABLE tb_delivery (
	dno NUMBER(5) NOT NULL, /* 배송번호 */
	company VARCHAR2(20), /* 택배회사 */
	shipnum VARCHAR2(255), /* 송장번호 */
	addr VARCHAR2(255), /* 배송지주소 */
	phone VARCHAR2(255), /* 배송전화번호 */
	startdate DATE, /* 배송출발일자 */
	ono NUMBER(5), /* 주문번호 */
	status NUMBER(3) /* 배송상태 */
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

/* 주문상세 */
CREATE TABLE tb_detail (
	dno NUMBER(5) NOT NULL, /* 주문상세번호 */
	ono NUMBER(5) NOT NULL, /* 주문번호 */
	pno NUMBER(5) NOT NULL, /* 상품번호 */
	price NUMBER(10), /* 주문가격 */
	amount NUMBER(3), /* 수량 */
	d_option VARCHAR2(255), /* 옵션 */
	orderdt DATE /* 주문일자 */
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

insert into tb_product values(1001,'kosta1','상품정보입니다',100,'텀블러','1.jpg','js',100,sysdate);
insert into tb_product values(1002,'kosta2','상품정보입니다',200,'텀블러','2.jpg','js',200,sysdate);
insert into tb_product values(1003,'kosta3','상품정보입니다',300,'텀블러','3.jpg','js',300,sysdate);
insert into tb_product values(1004,'kosta4','상품정보입니다',400,'텀블러','4.jpg','js',400,sysdate);
insert into tb_product values(1005,'kosta5','상품정보입니다',500,'텀블러','5.jpg','js',500,sysdate);

select * from  tb_product;
insert into tb_basket values(basket_seq.nextval, 1001,'test1','test-option1',3,3000);
insert into tb_basket values(basket_seq.nextval, 1002,'test1','test-option1',4,4000);
insert into tb_basket values(basket_seq.nextval, 1003,'test2','test-option1',2,2000);
insert into tb_basket values(basket_seq.nextval, 1003,'test2','test-option1',3,3000);
insert into tb_basket values(basket_seq.nextval, 1001,'test1','test-option1',1,1000);
select * from tb_basket;