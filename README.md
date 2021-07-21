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
## 11. Attribute에 들어있는 값들을 쉽게 꺼내 쓰는 방법
* ${“AttributeName”}
* Attribute에 들어있는 오브젝트를 쉽게 꺼내 쓸 수 있다.
* JSP를 서블릿으로 변환하는 과정에서 해당 클래스의 toString()을 호출하여 html 페이지에 출력한다.
* EL을 통해 인스턴스의 필드값에 접근하면 해당 필드의 getter를 자동으로 호출한다.
* Attribute에 들어있는 값이 인스턴스인 경우 .찍고 필드명을 쓰면 해당 필드의 getter를 자동으로 호출한다.-->getter가 없으면 에러
(파라미터에 들어있으면 매번 코드를 써야하지만 얘는 간단하게 꺼내기 가능)
```C
${fruitName}
${apple1.price}
```
## 12. forward와 redirect의 차이점
![1](https://user-images.githubusercontent.com/82793713/126425790-882dfcb3-0d1e-491b-adf8-23ad2836d7bb.png)
![2](https://user-images.githubusercontent.com/82793713/126425791-f8142f2f-4eb9-493f-9c5d-630216afca55.png)

### forward
* 동일한 web container에 있는 페이지로만 이동 가능
* 현재 실행중인 페이지와 forward에 의해 호출될 페이지는 requestm response 객체를 공유
* forward방식은 다음 이동한 URL로 요청정보를 그대로 전달한다. 그렇기 때문에 사용자가 최초로 요청한 요청정보는 다음 URl에서도 유효함
### redirect
* 웹 브라우저는 URl을 지시된 주소로 바꾸고 그 주소로 이동한다
* 다른 web container에 있는 주소오 이동이 가능하다
* 새로운 페이지에서는 request, response 객체가 새롭게 생성됨

1.  URL의 변화 여부(redirect: 변화 O, forward: 변화 X)
2.  객체의 재사용 여부(redirect: 재사용 X, forward: 재사용 O)
## 13. JSP 객체의 Scope
* JSP 객체의 수명은 설정된 Scope에 따라 달라진다.
* page: 페이지 스코프에 설정된 Attribute는 지역변수처럼 해당 페이지(서블릿)를 벗어나면 사라진다.
* request: request 스코프에 설정된 Attribute는 응답이 발생하기 전까지 수명이 유지된다.
* session: 사용자의 세션이 만료될때까지 수명이 유지된다. 세션은 브라우저 별로 존재한다.
-> IP주소가 같더라도 다른 브라우저를 사용하면 서버로부터 새로운 세션을 받아갈 수 있다.
* application: 어플리케이션 스코프에 저장하는 Attribute는 서버가 꺼질때까지 유지된다.
## 14. 세션(session)
1.	사용자가 서버로 요청을 보낸다
2.	요청이 올바르다면 서버는 알맞은 응답을 보낸다. 추가로 세션ID도 함께 보낸다.
3.	사용자의 웹 브라우저에 첫 번째 응답과 세션ID가 함께 도착한다.
4.	해당 웹서버에 다시 요청을 보냘 때 브라우저에 저장된 세선ID가 함께 전송된다
웹 서버는 해당 세션 ID를 이용해 사용자를 식별한다
5.	세션 ID는 사용자의 웹 브라우저가 종료될때까지 유지된다.
6.	세션 Attribute에 저장하는 자바 객체들은 사용자의 세션이 만료될때까지 살아있게 된다.

```C
session.setMaxInactiveInterval(sec) : 설정하지 않으면 기본 30분 후에 만료되며 sec넣은 값 동안 사용자의 요청이 없으면 만료되는 세션
session.invalidate : 세션을 만료시킨다.
session.removeAttribute("choice"); : 해당하는 세션을 지운다.
```
* 서블릿에서는 session, application은 내장 객체가 아니므로 따로 뽑아줘야함
```C
ServletContext application = req.getServletContext();
HttpSession session = req.getSession();
```
## 15. 외부 라이브러리 사용하기
### Dynamic Web Project에 외부 라이브러리를 사용하기 위해서는 WEB-INF/lib 폴더에 .kar 등을 넣어줘야 한다.
## 16. 자바빈 객체(JavaBean Object)
* JSP에서 데이터를 편리하게 주고받기 위한 클래스의 표준 형식
* 자바빈 표준에 맞춰 정의한 클래스는 JSP에서 편리하게 사용할 수 있다.
### 자바빈 객체의 규칙
* 반드시 public class여야 한다.
* 기본 생성자가 반드시 존재해야 한다.
* 필드의 접근 제어자가 private이어야 한다.
* 필드에는 반드시 getter/setter를 통해 접근해야 한다.
(이때 getter/setter의 메서드명이 규칙에 맞지 않으면 JSP의 편리한 기능을 이용할 수 없다.
### jsp:setPropetry
* 빈 객체의 필드를 채우는 기능을 하는 jsp태그
* property 속성에 *를 설정하면 파라미터의 값을 이용해 자동으로 빈 객체의 필드를 채운다
* 해당 빈 객체의 setter를 사용한다
* input태그의 name값과 클래스의 필드명을 일치시키면 자동으로 매핑해주는 경우가 굉장히 많다
```C
//form.jsp

<form action="./useBeanController.jsp">
	<label>이름</label> <input type="text" name="name" autocomplete="false" />
	<label>국어점수</label><input type="number" name="kor" /> 
	<label>영어점수</label><input type="number" name="eng" /> 
	<label>수학점수</label><input type="number" name="math" /> 
	<input type="submit" value="보내기" />
</form>
  -->여기서 전달한 name, kor, eng, math에 대해서
```
```C
//useBeanController.jsp

<jsp:useBean id="stu" class="chap03.bean.Student" scope="session"></jsp:useBean>
	<jsp:setProperty property="*" name="stu" />
```
## 16. JSP의 여러가지 charset 설정
1.	mata 태그의 charset 설정 : 클라이언트의 웹 브라우저가 페이지를 해석할 때 사용할 charset을 설정한다
2.	pageEncoding의 charset 설정 : 이 JSP 코드들을 서블릿으로 변환할 때 사용할 charset을 의미한다
3.	contentType의 charset 설정 : 서블릿 결과물의 종류 및 인코딩 타입을 설정한다.

### 이때 tomcat의 기본 설정은 utf-8이므로 EUC-KR로 바꾸려면 톰캣의 설정을 바꾸면 됨
#### server.xml의 Source부분에서 Connector태그의 URIEncoding=”EUC-KR”로 수정하면 됨
## 17. EL
#### .jsp에서는 EL을 통해 Attribute에 실려있는 값들을 편리하게 사용할 수 있다
```C
<%
	pageContext.setAttribute("most", "티모");
	request.setAttribute("most", "가렌");
	session.setAttribute("most", "다리우스");
	application.setAttribute("most", "야스오");
%>
	<li>그냥 출력: ${most }(가장 좁은 범위의 어트리뷰트가 선택됨-page)</li><%-- 티모 --%>
	<li>request를 출력: ${requestScope.most }</li><%-- 가렌 --%>
	<li>session를 출력: ${sessionScope.most }</li><%-- 다리우스 --%>
	<li>application를 출력: ${applicationScope.most }</li><%-- 야스오 --%>
```
#### EL을 통해 파라미터에 저장되어 있는 값 쉽게 출력하기
```C
${param.name}
```
#### EL의 리터럴
```C
<ul>
	<li>boolean : ${true }, ${false }</li>
	<li>정수 : ${123 }, ${234 }, ${123 + 456 }, ${5*30 }</li>
	<li>실수 : ${123.123 * 3 }, ${234 }, ${123 + 456 }, ${5*30 }</li>
	<li>문자열 : ${'hello ,world' }</li>
</ul>
```
### EL의 비교연산
```C
<!-- 비교: ==, !, eq, ne, lt, gt, le, ge...  -->
	3이 7보다 큰가요? : ${3 > 7 }, ${3 gt 7 }
  
<!-- 논리: and, or, not, &&, ||, ! -->
	${requestScope.most < sessionScope.most }
<!-- empty: "" 또는 null일 때 true -->
	${empty value1}
```
## 18. JSTL
### JSTL 작업환경 구축하기
1. 구글 jstl lib 검색 후 공식 홈페이지에서 다운로드를 누르면 https://tomcat.apache.org/download-taglibs.cgi 페이지로 이동
2. Impl, Spec, EL에 대한 jar를 다운하여 WEB-INF/lib에 넣는다
3. .jsp 맨 상단에 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>을 붙여줘야 함
### JSTL
* JSP에서 JAVA코드를 사용하기에 너무 불편해서 나온 라이브러리
* JAVA의 여러가지 기능을 태그 형태로 사용할 수 있다.
* JAVA의 모든 기능을 사용할 수 있는 것은 아니지만 유용하다.
* JSP코드를 깔끔하게 유지할 수 있다.
### JSTL core
* 데이터들을 다룰 때는 서블릿(자바)에서 하고 화면에 쉽게 표현하고 싶을 때 쓰는 것
* 자바의 주요 기능들이 구현되어 있는 커스텀 태그 라이브러리
* c:set : setAttribute를 편하게 사용할 수 있다
scope도 설정가능 -> page, request, session, application
 ```C
 <c:set var="fruit" value="apple" />
 ${fruit}
 ```
* c:if : if문을 편하게 사용할 수 있다. else if, else는 없다.
```C
<c:if test="true>
	<p>if문에서 실행될 문장</p>
</c:if>
```
* c:choose : if, else if, else처럼 사용되는 조건문, c:when, c:otherwise와 함께 사용한다.
```C
<c:set var="color" value="blue"></c:set>
	<c:choose>
		<c:when test="${empty color }">
			<p>color 어트리뷰트가 비어있습니다.</p>
		</c:when>
		<c:when test="${color == 'red' }">
			<p>color가 빨간색</p>
		</c:when>
		<c:otherwise>
			<p style="color: ${color};">빨간색 이외의 색상입니다.</p>
		</c:otherwise>
	</c:choose>
```
* c:forEach : 숫자 또는 iterable 객체를 이용해 반복문을 간편하게 작성할 수 있다.
    * varStatus.first : 첫 번째 반복일 때 true
    * varStatus.last : 마지막 반복일 때 true
    * varStatus.index : 몇 번째 반복인지 알 수 있음(0 base)
    * varStatus.count : 몇 개째인지 알 수 있음(1 base)
    * varStatus.begin : 몇부터 시작했는지 알 수 있음
    * varStatus.end : 언제 끝나는지 알 수 있음
```C
<c:forEach begin="0" end="10" var="i" varStatus="status">
	<div>이 반복문은 ${status.begin }부터 시작하여 ${status.end }에서 끝남</div>
</c:forEach>
```
* c:forTokens : 문자열을 split 한 뒤 하나씩 꺼내며 반복할 수 있다.
```C
<c:forEach items="${list }" var="item" varStatus="status">
	${status.count }. ${item }
</c:forEach>
```
* c:redirect : 간편하게 리다이렉트 할 수 있다.
```C
<c:if test="${empty login }">
	<c:redirect url="http://naver.com"></c:redirect>
</c:if>
```
* c:url : 복잡한 URL을 좀 더 편히라게 생성할 수 있다.
```C
만들어진 URL:
	<c:url value="/news/add"><!-- /chap04/news/add -->
		<c:param name="type" value="weather"></c:param>
		<c:param name="reporter" value="waitingPark"></c:param>
	</c:url>
	원래 URL만드는 방식: <%= request.getContextPath() %>/news/add?type=<%="type" %>&reporter=<%="reporter" %>
```
## 19. web.xml
* WebApplication Deployment Descriptor
* 톰캣에 현재 웹 어플리케이션에 대한 여러가지 설정을 전달할 수 있다.
* 웹 서버 프로그램이 톰캣에 실행될 때마다 톰캣이 이 설정파일을 초기화에 사용한다.	
### welcome-file-list
* ContextRoot로 접속한 사용자에게 보여줄 페이지를 설정한다(ContextRoot: 해당 프로젝트의 root 경로)
* web.xml에서 사용하는 경로는 webapp(WebContent)에서 시작한다.
## 20. WEB-INF 폴더
* WEB-INF 폴더에 있는 웹 페이지들은 폴더 경로를 통해 직접 접속할 수 없다
* 반드시 web.xml 또는 포워드(또는 include)를 이용해 연결되어야 한다.
* web.xml의 매핑 기능을 WEB-INF폴더와 함께 사용하면 URL과 실제 파일이 위치하고 있는 경로를 별개의 것으로 취급하여 사용할 수 있다.
* 장점: 실제 프로젝트 구조를 들키지 않을 수 있다. 확장자를 URI에서 제거할 수 있다.
단점: 매핑 없이는 절대로 직접 접근할 수 없다.

### servlet을 이용해 web.xml에 사용할 JSP파일 또는 서블릿을 등록할 수 있다.
* servlet-name: 사용할 서블릿의 이름
* jsp-file: 실제 파일의 위치
```C
<servlet>
	<servlet-name>cafe_home</servlet-name>
	<jsp-file>/WEB-INF/cafe/home.jsp</jsp-file>
</servlet>
```
### servlet-mapping을 통해 등록되어 있는 서블릿들을 원하는 URL과 매핑시킬 수 있다.
* servlet-name: 등록되어 있는 서블릿 이름들 중 사용할 서블릿을 선택
* url-pattern: 어떤 url로 접속했을 때 선택한 서블릿으로 연결할지 설정
* url-pattern에는 *를 사용할 수 있다.
* 하나의 서블릿에 여러 개의 url이 매핑될 수 있다.
```C
<servlet>
	<servlet-name>blog_home</servlet-name>
	<servlet-class>chap05.blog.controller.BlogHomeController
	</servlet-class>
</servlet>

<servlet-mapping>
	<servlet-name>blog_home</servlet-name>
	<url-pattern>/blog/</url-pattern>
</servlet-mapping>
```



