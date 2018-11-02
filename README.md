#필요라이브러리
## 1) JSTL(jstl.jar, standard.jar)
## 2) ojdbc6
## 3) JQuery

# 설정 작업
1) META-INF에 context.xml(DB property 저장)
2) lib에 필요 라이브러리 삽입
3) Listener에 property(서블릿 객체생성) 로딩
4) Dbutil.java 추가


# 작업순서
1) table 생성 후 테이블 내 레코드 삽입테스트
2) insert - select -  (selectBySearch) - Delete 순으로 jsp 페이지 생성
3) servlet 생성
4) 등록할 컨트롤러 properties에 추가
5) 컨트롤러 생성(전달 및 try { } catch 처리)
6) 서비스 생성 (service)
7) DAO 생성





