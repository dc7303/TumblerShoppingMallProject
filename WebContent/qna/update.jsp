<%@ page info="게시판 수정하기" contentType="text/html;charset=UTF-8" %>

<HTML>
<HEAD>
<link rel="stylesheet" href="css/style.css">

<SCRIPT >
function checkValid() {
	var f = window.document.qnaUpdateForm;
	if ( f.qnaBoardSubject.value == "") {
	    alert( "제목을 입력해 주세요." );
	    f.qnaBoardSubject.focus();
		return false;
    }
	if ( f. qnaBoardContent.value == "" ) {
		alert( "내용을 입력해 주세요." );
		f. qnaBoardContent.focus();
		return false;
	}
	if ( f.qnaBoardPwd.value == "" ) {
		alert( "비밀번호를 입력해 주세요." );
		f.qnaBoardPwd.focus();
		return false;
	}
 
}

</SCRIPT>

</HEAD>

<BODY>


<form name=qnaUpdateForm method=post action="qna" onSubmit="return checkValid()">
    <input type="hidden" name="command" value="qnaUpdate" >
    <input type='hidden' name='qnaBoardQno' value="${dto.qnaBoardQno}">
	<table align="center" cellpadding="5" cellspacing="1" width="600" border="1">
    <tr>
        <td width="1220" height="20" colspan="2" bgcolor="#00cc00">
            <p align="center"><font color="white" size="3"><b>  게시물 수정하기</b></font></p>
        </td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">제목</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="qnaBoardSubject" size="30"
		 value="${dto.qnaBoardSubject}"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">내용</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:9pt;">
		<input type=text name="qnaBoardContent" size="30"
		 value="${dto.qnaBoardContent}"></span></b></td>
    </tr>
    
 <!--  
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">비밀번호</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;"><input type=password name="password" size="12"> 
            (비밀번호가 맞아야 수정이 가능합니다.)</span></b></td>
    </tr>
    -->
    <tr>
        <td width="450" height="20" colspan="2" align="center"><b><span style="font-size:9pt;">
		<input type="submit" value="수정하기"> <input type="reset" value="다시쓰기"></span></b></td>
    </tr>
</table>
</form>
<hr>
<div align=right><span style="font-size:9pt;">&lt;<a href="${path}/qna?command=list">리스트로 돌아가기</a>&gt;</span></div>
</BODY>
</HTML>







