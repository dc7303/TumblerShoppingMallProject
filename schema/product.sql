select * from product;

--상품 테이블 삭제
drop table product;

--상품 테이블 생성
create table product(
	no int primary key,				--상품정보
	title varchar2(100) not null,	--상품명
	content varchar2(50),			--상품정보
	regDate varchar2(20) not null,	--카테고리
	reg_pwd date not null,			--등록일자
	photo varchar2(20)				--사진
)

select * from product;

--레코드 추가
insert into product(no,title,content,regDate,reg_pwd,photo) 
values('1','SS DW 스노우 민트 투고 텀블러 473ml','프로모션 상품','스타벅스',sysdate,'사진~');
insert into product(no,title,content,regDate,reg_pwd,photo) 
values('2','SS DW 홀리데이 그레이 투고 텀블러 473ml','프로모션 상품','스타벅스',sysdate,'사진~');
insert into product(no,title,content,regDate,reg_pwd,photo) 
values('3','SS 산타 기프트 참 텀블러 355ml','프로모션 상품','스타벅스',sysdate,'사진~');

commit


---------------------다시------------------
drop table product;

create table product(
	productNum int primary key,				--상품번호
	productName varchar2(100) not null,	--상품명
	productInfo varchar2(50),			--상품정보
	productPrice int not null,				--가격
	productCatergory varchar2(30) not null,	--카테고리
	productBrand varchar2(20)				--브랜드
	productPhoto varchar2(20)				--사진
)

select * from product;



insert into product(productNum,productName,productInfo,productPrice,productCatergory,productBrand)
values('1','SS DW 스노우 민트 투고 텀블러 473ml','프로모션 상품','45500','스테인리스 텀블러','스타벅스');
insert into product(productNum,productName,productInfo,productPrice,productCatergory,productBrand)
values('2','픽시랜드 워터볼 텀블러 355ml','프로모션 상품','39500','플라스틱 텀블러','스타벅스');
insert into product(productNum,productName,productInfo,productPrice,productCatergory,productBrand)
values('3','SS 산타 기프트 참 텀블러 355ml','프로모션 상품','55500','스테인리스 텀블러','스타벅스');

commit

-----------------------------------------------------

insert into product(no,title,content,price,regDate,brand)
values('1','SS DW 스노우 민트 투고 텀블러 473ml','프로모션 상품','45500','스테인리스 텀블러','스타벅스');
insert into product(no,title,content,price,regDate,brand)
values('2','픽시랜드 워터볼 텀블러 355ml','프로모션 상품','39500','플라스틱 텀블러','스타벅스');
insert into product(no,title,content,price,regDate,brand)
values('3','SS 산타 기프트 참 텀블러 355ml','프로모션 상품','55500','스테인리스 텀블러','스타벅스');

commit

-------------------------------------------------------------
drop table product;

create table product(
	pno int primary key,			--상품번호
	pname varchar2(100) not null,	--상품이름
	info varchar2(255),				--상품정보
	price int not null,				--상품가격
	category varchar2(40) not null,	--카테고리
	photo varchar2(255),			--사진
	brand varchar2(255),			--브랜드
	stock int not null,				--재고량
	regdt date not null				--등록일
)


insert into product(pno,pname,info,price,category,photo,brand,stock,regdt)
values('1','SS DW 스노우 민트 투고 텀블러 473ml','프로모션 상품','45500','스테인리스','사진~','스타벅스',100,sysdate);
insert into product(pno,pname,info,price,category,photo,brand,stock,regdt)
values('2','픽시랜드 워터볼 텀블러 355ml','프로모션 상품','39500','플라스틱','사진~','스타벅스',200,sysdate);
insert into product(pno,pname,info,price,category,photo,brand,stock,regdt)
values('3','SS 산타 기프트 참 텀블러 355ml','프로모션 상품','55500','스테인리스','사진~','스타벅스',150,sysdate);
 
commit

select * from product;

select * from product where pno=1;

update product set pname='지민쓰',info='울랄라',price=123,category='플라스틱',brand='스벅',stock=56 where pno=2;

