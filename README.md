# JspStudy
## 0. 작업환경 세팅
1.  아파치 톰캣을 다운(http://tomcat.apache.org/)
2.  내 pc-고급 시스템 설정-환경변수-시스템 변수- 새로 만들기를 통해 시스템 변수를 새로 만든다
(변수 이름: JRE-HOME, 변수 값: jre가 설치되어 있는 경로
3.  cmd 창에서 tomcat이 깔려있는 디렉토리를 찾아가서 startup.bat을 실행해서 톰캣 서버를 연다
4.  톰캣 서버가 열린 상태에서 http://localhost:8080/를 접속하여 확인해 본다.
5.  이클립스에 들어가서 다운받은 톰캣 버전을 server에 연결한다.
## 1. 웹 서버
* 24시간 대기하고 있다가 사용자가 접속하면 사용자가 원하는 웹 페이지를 응답(reaponse)해주는 프로그램
* 사용자가 어떤 웹 페이지를 원하는지는 사용자가 요청(request)하는 URL을 통해 구분할 수 있다
* HttpServletRequest: 사용자가 보낸 모든 요청 정보를 담을 수 있는 클래스
* HttpServletReponse: 받은 요청을 통해 알맞은 응답을 담아놓을 수 있는 클래스
## 2. 웹 사이트가 클라이언트에게 보여지는 과정
* 호스트: 웹 페이지를 가지고 있는 웹 페이지의 주인
* 클라이언트: 웹 서버에 접속하는 사용자
1.  클라이언트가 호스트에게 원하는 웹 페이지를 보여달라고 요청한다. 요청할 때 원하는 페이지가 무엇인지 웹 주소(URL)에 적어서 보낸다
2.  사용자의 요청이 Apache-Tomcat에 도착한다. Apache-Tomcat에 등록되어 있는 URL 매핑들 중 일치하는 자원을 찾는다.
3.  등록된 자원들 중 사용자의 요청에 따라 다른 결과들이 나오는 페이지를 동적 웹 페이지라고 한다
4.	클라이언트의 요청이 올바른 요청이였다면 (톰캣에 등록된 자원이 맞다면) 해당 자원을 만들어서(Servlet 프로그램 실행) 응답한다. 
(또는 이미 있는 자원을 그대로 응답한다, 동적 웹 페이지가 아닌 자원들)
5.	웹 서버에서 응답한 자원이 요청 보냈던 클라이언트의 웹 브라우저에 도착한다
웹 브라우저는 응답 받은 내용을 해석하여 사용자에게 보여준다
## 3. 자바에서 Servlet하는 방법
### class에 HttpServlet을 상속받기
* doGet(): Get방식 요청이 서블릿으로 도착했을 때 실행되는 콜백 메서드
* doPost(): Post방식 요청이 서블릿으로 도착했을 때 실행되는 콜백 메서드
```C
@WebServlet("/page/controller2")
public class PageNumController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("page");
		response.sendRedirect(String.format("/chap02/forward/view/page%s.jsp", page));
	}
}
```
## 4. JSP (Java Server Page)
* Servlet으로 html을 입력하기 너무 불편 -> JSP 등장 
* .jsp가 톰캣에 등록되는 과정
    * JSP로 작성한 코드 -> Servlet 코드로 변환 -> 컴파일 -> Tomcat에 등록
* 서블릿이 톰캣에 등록되는 과정
    * Servket -> 컴파일 -> Tomcat에 등록
* JSP: html 코드가 메인, JAVAS코드를 특수한 영역 태그를 사용해 추가
* 서블릿: JAVA 코드가 메인, html코드를 문자열로 추가
    * html코드의 양이 많은 페이지를 생성할 땐 JSP를 사용
    * JAVA코드의 양이 많은 페이지를 생성할 땐 서블릿을 사용하는 것이 유리
* .jsp -> 번역 -> .java(Servlet) -> complie -> .class 상태로 tomcat에 적재됨

## 5. JSP Script
* <% %> : 모든 자바 코드를 사용할 수 있는 영역(메서드 내부에 선언할 수 있는 것들) -> 함수 선언 불가능
* <%! %> : 함수를 선언할 수 있는 영역
* <%= %> : 원하는 값을 HTML영역에 출력(out.print()의 간편한 버전) -> 하나의 한번밖에 못함
* <%@ %> : 현재 해당 서블릿에 대한 다양한 설정
## 6. request로 알 수 있는 정보들
```C
request.getRequestURI(): URI를 알 수 있음
request.getRequestURL(): URL를 알 수 있음
request.getContextPath(): 현재 프로젝트를 톰캣에 등록할 때 사용하고 있는 경로 이름
```
### 정보들을 주고 받을 때 한글이 깨질 때
```C
req.setCharacterEncoding("EUC-KR"); 
resp.setCharacterEncoding("EUC-KR");
//혹은 맞는 문자 인코딩을 세팅
```
## 7. parameter 값 받아오기
```C
request.getParameter("name"): name의 value를 String 타입으로 받아옴
request.getParameterValues(“name”): 여러 개의 name을 String[] 배열 타입으로 받아옴
```
## 8. forward
* 전달 받은 값에 따라서 다른 내용을 응답해줘야 하는 경우 서블릿만 사용하면 코드가 매우 지저분해진다.
* 따라서 사용자의 요청을 다른 페이지로 분배하여 응답을 생성하는 것이 바람직하다.
* 이때, 다른 .jsp 페이지로 request를 그대로 전달하여 전달한 .jsp에서 응답을 생성하는 것을 forward라고 한다.
* RequestDispatcher클래스를 이용해 getRequestDispatcher로 페이지 정보를 담고 forward로 보냄
```C
String page = request.getParameter("page");
RequestDispatcher dispatcher = request.getRequestDispatcher(String.format("/forward/view/page%s.jsp, page));
```
* include는 다른 .jsp 페이지로 request를 보낸 후 생성된 결과를 이 서블릿으로 다시 가져온다.
## 9. 리다이렉트(Redirect)
* 이곳(서블릿 or JSP)으로 요청한 사용자에게 다른곳으로 다시 요청할 것을 명령한다.
* 사용자 웹 브라우저에서 다시 요청 보내야할 URL을 사용해야 한다.
```C
String page = request.getParameter("page");
response.sendRedirect(String.format("/forward/view/page%s.jsp, page));
```
## 10. Attribute
* setAttribute : 리퀘스트 객체에 attribute에 원하는 데이터를 실어놓을 수 있다.
* 리퀘스트에 실려있는 attribute는 포워드하는 페이지로 그대로 전달된다
```C
req.setAttribute("fruilDetail", sb);
```
* 포워드된 jsp 페이지에서는 주로 화면을 구성한다.
* attribute를 받아서 request.getAttribute("fruitDetail")로 받을 수 있다.
* parameter는 String밖에 전달을 못하지만 Attribute는 다양한 형식을 전달받을 수 있다.
```C
clasee Apple{
  int price;
  int size;
  public Apple(){
    this.price = (int)(Math.randomo() * 10) + 10;
    this.size = (int)(Math.randomo() * 10) + 10;
  }
}
req.setAttribute("apple1", new Apple());
req.setAttribute("apple2", new Apple());
req.setAttribute("appleArray", new Apple[] {new Apple(), new Apple(), new Apple()});

Apple apple = (Apple)req.getAttribute("apple1");
```
## 11. Attribute에 (7p)









