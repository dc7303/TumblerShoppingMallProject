<%@ page info="게시판 수정하기" contentType="text/html;charset=UTF-8" %>
<HTML>
<HEAD>


<SCRIPT >
function checkValid() {
	var f = window.document.updateForm;

	if ( f.title.value == "" ) {
		alert( "제목을 입력해 주세요." );
		f.title.focus();
		return false;
	}
	if ( f.content.value == "" ) {
        alert( "설명을 입력해 주세요." );
        f.content.focus();
        return false;
    }

    
}

</SCRIPT>

</HEAD>

<BODY>


<form name=updateForm method=post action="${path}/frontNotice" onSubmit="return checkValid()">

    <input type="hidden" name="command" value="noticeUpdate" >
    <input type='hidden' name='NoticeNum' value="${noticeDto.getNoticeBoardNum()}">
	<table align="center" cellpadding="5" cellspacing="1" width="600" border="1">
    <tr>
        <td width="1220" height="20" colspan="2" bgcolor="#00cc00">
            <p align="center"><font color="white" size="3"><b>공지사항 수정하기</b></font></p>
        </td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">제목</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="title" size="30"
		 value="${noticeDto.getNoticeBoardSubject()}"></span></b></td>
    </tr>
 
    
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">내 용</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:9pt;">
		<textarea name="content" cols="50" rows="10">${noticeDto.getNoticeBoardContent()}</textarea></span></b></td>
    </tr>
   
    <tr>
        <td width="450" height="20" colspan="2" align="center"><b><span style="font-size:9pt;">
		<input type="submit" value="수정하기"> <input type="reset" value="다시쓰기"></span></b></td>
    </tr>
</table>
</form>
<hr>
<div align=right><span style="font-size:9pt;">&lt;<a href="${path}/frontNotice?command=noticeSelectAll">리스트로 돌아가기</a>&gt;</span></div>
</BODY>
</HTML>







