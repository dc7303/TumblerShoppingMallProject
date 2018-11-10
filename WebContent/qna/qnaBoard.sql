drop table qnaBoard;

create table qnaBoard(
    qnaBoardQno number(5) primary key,
   qnaBoardSubject varchar2(20) not null, 
    qnaBoardContent varchar2(20) not null,
    qnaBoardPwd varchar2(20) not null,
    qnaBoardDate date not null,
   qnaBoardUserId varchar2(15) 
);
	drop sequence qna_seq
	create sequence qna_seq	;

	
	insert into  qnaBoard values(qna_seq.nextval,'제품문의','제품','1234',sysdate,'jjj');
	insert into  qnaBoard values(qna_seq.nextval,'재질문의','제품','1234',sysdate,'mmm');
	insert into  qnaBoard values(qna_seq.nextval,'재질문의','제품','1234',sysdate,'kkk');

	update qnaBoard set qnaBoardSubject=? , qnaBoardContent=?  where qnaBoardQno=?

	commit
	select * from qnaBoard;
	select * from qnaBoard where  qnaBoardContent ='test';
	update qnaBoard set qnaBoardSubject='aaa',qnaBoardContent='aaa' where qnaBoardQno=1