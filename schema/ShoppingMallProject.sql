select * from tb_notice;

select rownum, a.nno, a.title,a.content,a.regdt
from (
	select nno, title,content,regdt
	from tb_notice
	order by regdt desc) a
where rownum between 5 and 10

select * from (select rownum num, nno, title,content,regdt from (select * from tb_notice order by regdt)) where num between 2 and 10



select count(*) totalcount from tb_notice


insert into tb_notice values(notice_seq.nextval,'�׽�Ʈ ����1','�׽�Ʈ ���� ����1',sysdate);
insert into tb_notice values(notice_seq.nextval,'�׽�Ʈ ����2','�׽�Ʈ ���� ����2',sysdate);
insert into tb_notice values(notice_seq.nextval,'�׽�Ʈ ����3','�׽�Ʈ ���� ����3',sysdate);
insert into tb_notice values(notice_seq.nextval,'�׽�Ʈ ����4','�׽�Ʈ ���� ����4',sysdate);

commit