select * from tb_notice;

select rownum, a.nno, a.title,a.content,a.regdt
from (
	select nno, title,content,regdt
	from tb_notice
	order by regdt desc) a
where rownum between 5 and 10

select * from (select rownum num, nno, title,content,regdt from (select * from tb_notice order by regdt)) where num between 2 and 10



select count(*) totalcount from tb_notice


insert into tb_notice values(notice_seq.nextval,'테스트 공지1','테스트 공지 내용1',sysdate);
insert into tb_notice values(notice_seq.nextval,'테스트 공지2','테스트 공지 내용2',sysdate);
insert into tb_notice values(notice_seq.nextval,'테스트 공지3','테스트 공지 내용3',sysdate);
insert into tb_notice values(notice_seq.nextval,'테스트 공지4','테스트 공지 내용4',sysdate);

commit