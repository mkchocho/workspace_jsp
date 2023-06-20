/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.73
 * Generated at: 2023-06-19 03:17:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import com.util.BSPageBar;

public final class memberList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/include/gym_footer.jsp", Long.valueOf(1684303334210L));
    _jspx_dependants.put("/include/gym_header.jsp", Long.valueOf(1687138473868L));
    _jspx_dependants.put("/common/bootstrap_common.jsp", Long.valueOf(1684295047261L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("java.util.Map");
    _jspx_imports_classes.add("com.util.BSPageBar");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("        \r\n");

    // 스크립틀릿 - 지변, 메소드선언 불가함, 인스턴스화 가능함
    int size = 0;// 지변이니까 초기화를 생략하면 에러발생함
    List<Map<String,Object>> mList = (List<Map<String,Object>>)request.getAttribute("mList");
    if(mList !=null) {
      size = mList.size();// 3	
    }
    int numPerPage=3;
    int nowPage = 0; //초기값 세팅
    //member/memberCRUD?method=memberSelect&nowPage=1
    //쿼리스트링으로 현재 내가 바라보는 페이지 번호를 넘긴다
    if(request.getParameter("nowPage")!=null){
    	//String을 int로 바꿔주는 메소드 호출하기
    	nowPage = Integer.parseInt(request.getParameter("nowPage"));
    }
    //out.print(size);// 0이 출력됨
    //out.print(mList);

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>회원관리</title>\r\n");
      out.write("\r\n");
      out.write("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\">\r\n");
      out.write(" <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4\" crossorigin=\"anonymous\"></script>\r\n");
      out.write(" 	<!--\r\n");
      out.write(" 	https://getbootstrap.com/docs/5.2/getting-started/download/\r\n");
      out.write(" 	 위 사이트에서 CDN via jsDelivr 하단 2줄 코드 복붙 \r\n");
      out.write(" 	 -->\r\n");
      out.write(" <script src=\"https://kit.fontawesome.com/cc13ae136b.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write(" 	<!-- fontawesome 로그인해서 고유코드 조회할 때 밑에 생성해준 코드 복붙 -->\r\n");
      out.write(" \r\n");
      out.write("<!-- \r\n");
      out.write("	css나 js파일명에 min이 있는 것과 없는 것 차이점\r\n");
      out.write("	통상 js도 보안적인 이슈 때문에 소스를 분리해서 관리 배포 하게 되었다.\r\n");
      out.write("	실제 페이지가 렌더링 되기 전에 다운로드가 된 후에 실행이 되는 구조를 갖는다\r\n");
      out.write("	여백, 공백, 들여쓰기 등이 포함되면 파일의 크기가 더 커진다\r\n");
      out.write("	여백, 공백, 들여쓰기 등을 다 생략하고 바짝 붙여서 코드가 작성된 버전이다.\r\n");
      out.write("	정적 페이지 처리 주체 - 브라우저 - 다운로드해서 가지고 있어야 함\r\n");
      out.write(" --> \r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/css/member.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/common.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    // 검색 버튼을 눌렀을 때 호출되는 함수\r\n");
      out.write("    const memberSearch = () => {\r\n");
      out.write("    	const gubun = document.querySelector(\"#gubun\").value; // 분류선택 - mem_id, mem_name, mem_address\r\n");
      out.write("    	const keyword = document.querySelector(\"#keyword\").value; // 사용자가 입력한 키워드\r\n");
      out.write("        // console.log(gubun + \", \" + keyword);\r\n");
      out.write("    	// 브라우저 내장객체 중 최상위 객체 - window객체임\r\n");
      out.write("    	// window.location은 location도 window객체의 자손을 뜻하는 것\r\n");
      out.write("    	window.location.href=\"http://localhost:9000/member/memberCRUD?method=memberSelect&gubun=\"+gubun+\"&keyword=\"+keyword;\r\n");
      out.write("    }\r\n");
      out.write("    const searchEnter = (event) => {\r\n");
      out.write("    	if(window.event.keyCode==13) {\r\n");
      out.write("    		memberSearch();\r\n");
      out.write("    	}	\r\n");
      out.write("    }\r\n");
      out.write("    // 가입 버튼을 input 태그로 했으므로 반드시 submit()호출이 필요하다\r\n");
      out.write("    // ES6지원 - 화살표 함수 - arrow function\r\n");
      out.write("    const memberInsert = () => {\r\n");
      out.write("    	document.querySelector(\"#f_member\").submit();//<form id=\"f_member\">\r\n");
      out.write("    	//document.getElementById(\"f_member\").submit();\r\n");
      out.write("    }\r\n");
      out.write("  	const memberDetail = (user_no) => {\r\n");
      out.write("  		console.log(user_no);\r\n");
      out.write("  		location.href=\"./memberCRUD?method=memberDetail&mem_no=\"+user_no;\r\n");
      out.write("  	}\r\n");
      out.write("  	const zipcodeForm = () => {\r\n");
      out.write("  		//파라미터로 값을 넘길 때 싱글 혹은 더블 쿼테이션을 붙이지 않으면 변수취급을 함 - 주의\r\n");
      out.write("  		cmm_window_popup('zipcodeSearch.jsp' , '700' , '600' , 'zipcodeForm' );\r\n");
      out.write("  	}\r\n");
      out.write("  	</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <!-- header start -->\r\n");
      out.write("    ");
      out.write('\r');
      out.write('\n');

	//스크립틀릿 - 자바코드를 작성할 수 있는 영역
	//여기서는 메소드를 선언할 수 없다
	//여기서 선언한 변수는 서블릿 코드의 doService 메소드 안에 들어가므로 모두 지변이다.
	//인스턴스화나 변수 선언 제어문 사용은 가능하다
	//KakaoController에서 세션에 저장해둔 이름 가져오기
	 String nickname = null;
	nickname = (String)session.getAttribute("nickname");
	out.print(nickname);//출력하는 여기는 html땅 

      out.write("\r\n");
      out.write("<!-- ");
      out.print(nickname );
      out.write("  -->\r\n");
      out.write("<nav class=\"navbar navbar-expand-lg bg-light\">\r\n");
      out.write("  <div class=\"container-fluid\">\r\n");
      out.write("    <a class=\"navbar-brand\" href=\"/gym.jsp\">TerrGYM</a>\r\n");
      out.write("    <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("      <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("    </button>\r\n");
      out.write("    <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\r\n");
      out.write("      <ul class=\"navbar-nav\">\r\n");
      out.write("        <li class=\"nav-item\">\r\n");
      out.write("          <a class=\"nav-link active\" aria-current=\"page\" href=\"/auth2/loginForm.jsp\">로그인</a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"nav-item\">\r\n");
      out.write("          <a class=\"nav-link\" href=\"/member/memberCRUD?method=memberSelect\">회원관리</a>\r\n");
      out.write("        </li>\r\n");
      out.write("		<li class=\"nav-item\">\r\n");
      out.write("          <a class=\"nav-link\" href=\"/notice/noticeList.pj1\">공지사항</a>\r\n");
      out.write("        </li>\r\n");
      out.write("        \r\n");
      out.write("        <li class=\"nav-item\">\r\n");
      out.write("          <a class=\"nav-link\" href=\"/board/boardList.pj2\">자유게시판</a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"nav-item\">\r\n");
      out.write("          <a class=\"nav-link\" href=\"/member2/memberList.pj2\">회원관리2</a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"nav-item\">\r\n");
      out.write("       		<a class=\"nav-link\" href=\"#\">QnA게시판</a>\r\n");
      out.write("   	 	</li>\r\n");
      out.write("      </ul>\r\n");
      out.write("      \r\n");
      out.write("     <!-- 로그인 성공 시 세션에 담긴 이름을 출력하고 로그인 성공한 경우이므로 로그아웃 버튼 추가 -->\r\n");
      out.write("     \r\n");
      out.write("\r\n");

	if(nickname !=null){

      out.write(" \r\n");
      out.write("	<form class=\"d-flex mb-2 mb-lg-0\" role=\"search\">\r\n");
      out.write("		<div class = \"me-auto mt-2 mb-lg-0\">");
      out.print(nickname );
      out.write("님.&nbsp;</div>\r\n");
      out.write("		<!--\r\n");
      out.write("		button 클릭을 했을 때 onclick은 이벤트 핸들러 이름이다\r\n");
      out.write("		클릭이 되면 느끼는 것은 브라우저 화면\r\n");
      out.write("		감지하는 건 js처리를 해야 함 - 이벤트 처리 담당은 자바스크립트 처리함\r\n");
      out.write("		 -->\r\n");
      out.write("		<input type=\"button\" onclick=\"logout()\" class=\"btn btn-outline-primary\" value=\"로그아웃\">\r\n");
      out.write("	</form>\r\n");
      out.write("	<script type=\"text/javascript\">\r\n");
      out.write("		//아래 함수는 로그아웃 버튼이 눌렸을 때 호출됨\r\n");
      out.write("		const logout =() => {\r\n");
      out.write("			console.log('11');//출력이 된다면 호출성공했다는 것임 \r\n");
      out.write("			//페이지 이동 -> get방식 -> 주소창이 바뀐다\r\n");
      out.write("			location.href=\"/auth2/logout.jsp\";//세션에 저장된 nickname을 삭제하기 구현\r\n");
      out.write("		}\r\n");
      out.write("	</script>\r\n");
      out.write("\r\n");

	}

      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</nav>");
      out.write("\r\n");
      out.write("    <!-- header end -->\r\n");
      out.write("    <!-- body start -->\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("       <div class=\"page-header\">\r\n");
      out.write("          <h2>회원관리<small>회원목록</small></h2>\r\n");
      out.write("          <hr />\r\n");
      out.write("       </div>\r\n");
      out.write("       <!-- 검색기 시작 -->\r\n");
      out.write("       <div class=\"row\">\r\n");
      out.write("          <div class=\"col-3\">\r\n");
      out.write("              <select id=\"gubun\" class=\"form-select\" aria-label=\"분류선택\">\r\n");
      out.write("                 <option defaultValue>분류선택</option>\r\n");
      out.write("                 <option value=\"mem_id\">아이디</option>\r\n");
      out.write("                 <option value=\"mem_name\">이름</option>\r\n");
      out.write("                 <option value=\"mem_address\">주소</option>\r\n");
      out.write("              </select>        \r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"col-6\">\r\n");
      out.write("             <input type=\"text\" id=\"keyword\" class=\"form-control\" placeholder=\"검색어를 입력하세요\" \r\n");
      out.write("                  aria-label=\"검색어를 입력하세요\" aria-describedby=\"btn_search\" onkeyup=\"searchEnter()\"/>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"col-3\">\r\n");
      out.write("             <button id=\"btn_search\" class=\"btn btn-danger\" onclick=\"memberSearch()\">검색</button>\r\n");
      out.write("          </div>\r\n");
      out.write("       </div>    \r\n");
      out.write("       <!-- 검색기 끝 -->\r\n");
      out.write("       \r\n");
      out.write("       <!-- 회원목록 시작 -->\r\n");
      out.write("       <div class='member-list'>\r\n");
      out.write("          <table class=\"table table-hover\">\r\n");
      out.write("              <thead>\r\n");
      out.write("                 <tr>\r\n");
      out.write("                     <th width=\"10%\">#</th>\r\n");
      out.write("                     <th width=\"20%\">아이디</th>\r\n");
      out.write("                     <th width=\"20%\">이름</th>\r\n");
      out.write("                     <th width=\"50%\">주소</th>\r\n");
      out.write("                 </tr>\r\n");
      out.write("              </thead>\r\n");
      out.write("              <tbody>\r\n");

	//몇번째 라인에서 터졌니? -IndexOutofBoundException, NullPointerException
	// for(int i=0; i<size; i++) {
	//페이징처리에 필요한 전변은 뭐가 있었나?
	//nowPage : 현재 내가 바라보는 페이지
	//totalRecord == size : 전체 회원의 수
	//페이징처리를 필요로 하는 페이지이름은? pagePath변수에 오는 값은 페이징처리를 적용할 페이지가 되는 것이다
	//예컨데) imageList?method=imageSelect&nowPage=1
	// noticeList?method=noticeSelect&nowPage=1
	// qnaList?method=noticeSelect&nowPage=1
	//numPerPage는 한 페이지에 글을 몇개씩 보여줄거니?
			//(0*3);i<(0*3)+3;i=i+1 -> 0, 1, 2
			//(1*3);i<(1*3)+3;i=i+1 -> 3, 4, 5
			//2번을 클릭했을 때 따져 보자
			//6;i<9;i=i+1 -> 6, 7, 8
			if(mList != null && size>0	) {//조회 결과가 존재하면
				out.print("before===>"+nowPage+","+numPerPage+",");
			out.print("<br/>");
		//for(초기화:조건식:증감연산자)
		//for(초기화;i<3;i=i+1) - i가 달라지니까 ..
		//for(i=0, 3, 6, 9)
	  	 for(int i=nowPage*numPerPage; i<(nowPage*numPerPage)+numPerPage; i++) { //0 1 2 0 1 2
  		out.print("for문 내부===>"+nowPage+","+numPerPage+","+i);
	  		 //여기야? -이전에
		//마지막 페이지의 숫자가 3바퀴 모두 갖고 있지 않으면 for문을 탈출 해야 한다.
		//왜냐하면 i값에 해당하는 위치의 주소번지가 존재하지 않기 때문이다. - 왜냐면 밖에는 List타입이 있지만 그 안에는 Map타입이다
		//이 Map 타입안에 실제 회원님의 정보들이 들어 있으니까....
		//IndexOutofBoundException이었다. → List의심해 보자 → 왜냐면 배열과 비슷하게 index로 주소번지를 가져오니까...
  		if(size == i) break;	//조건절에서 무조건 numPerPage 숫자 만큼 반복 된다. - 변수i가 세번씩 끊어서 
  		 Map<String, Object> rmap = mList.get(i);
  		//아님 요기야? -이후에
  				
  				

      out.write("              \r\n");
      out.write("                 <tr>\r\n");
      out.write("                     <th>");
      out.print( rmap.get("mem_no") );
      out.write("</th><!--  rmap=null 이라고 가정해보자 NullPointerException -->\r\n");
      out.write("                     <th>\r\n");
      out.write("<!-- 자바스크립트와 자바코드의 섞어쓰기가 가능함\r\n");
      out.write("서버에서 실행된 결과가 텍스트로 클라이언트에 다운로드 되니까 결국은 문자열이 들어 있기 때문에 가능함 -->\r\n");
      out.write("                     	<a href=\"javascript:memberDetail('");
      out.print(rmap.get("mem_no"));
      out.write("')\">");
      out.print( rmap.get("mem_id") );
      out.write("</a>\r\n");
      out.write("                     </th>\r\n");
      out.write("                     <th>");
      out.print( rmap.get("mem_name") );
      out.write("</th>\r\n");
      out.write("                     <th>");
      out.print( rmap.get("mem_address") );
      out.write("</th>\r\n");
      out.write("                 </tr>\r\n");

	}//end of for
	}//end of if - 회원이 한 명이라도 있을 때
			else{//회원이 존재하지 않는 경우

      out.write("   \r\n");
      out.write("\r\n");
      out.write("	<tr>\r\n");
      out.write("		<td colspan=\"4\">조회 결과가 존재하지 않습니다.</td>\r\n");
      out.write("	</tr>\r\n");
      out.write("\r\n");

}

      out.write("                               \r\n");
      out.write("              </tbody>\r\n");
      out.write("          </table>\r\n");
      out.write("          <!-- =============[[ 페이징처리{페이지네이션 처리} ]]============== -->\r\n");
      out.write("		 <div style =\"display:flex;justify-content:center\">\r\n");
      out.write("		 <ul class=\"pagination\">\r\n");

	//스크립트릿 -모두 지변이다, 메소드 선언은 불가함, 인스턴스화는 가능함
	//왜 가능하냐면 파라미터가 없으니까 가능하지 않을까
	//생긴 꼴이 인스턴스 변수, 변수명으로 호출할 수 있다면 넌 전변이다
		//파라미터로 넘겨지는 값은 지변으로 한다.
		//대신 공통 클래스의 생성자 안에서는 전변으로 다시 초기화가 된다. - 유지된다 - 안심하자.
		String pagePath="/member/memberCRUD?method=memberSelect";
		//인스턴스화를 통해서 생성자가 호출이 된다 - 인지하고 있니?
		BSPageBar pb = new BSPageBar(numPerPage, size ,nowPage ,pagePath);//디폴트 생성자 호출하기 - 파라미터가 한 개도 없는 생성자 - 생략가능함 - 누가해준데 - JVM이
		//페이징처리에 피룡한 태그문자열은 setPageBar()에서 만들어졌다.
		//그런데 getPageBar()호출로 setPageBar() 경유가 되었나?
		out.print(pb.getPageBar());
		
	

      out.write("	\r\n");
      out.write("		</ul>\r\n");
      out.write("		</div>\r\n");
      out.write("          \r\n");
      out.write("          \r\n");
      out.write("           \r\n");
      out.write("          <hr />\r\n");
      out.write("          <!-- =============[[ 페이징처리{페이지네이션 처리 } ]]============== -->\r\n");
      out.write("          \r\n");
      out.write("          <div class='member-footer'>\r\n");
      out.write("              <button class=\"btn btn-warning\" onclick=\"memberSearch()\">\r\n");
      out.write("              전체조회\r\n");
      out.write("              </button>&nbsp; \r\n");
      out.write("              <button type=\"button\" class=\"btn btn-success\" data-bs-toggle=\"modal\" data-bs-target=\"#memberForm\">\r\n");
      out.write("              회원가입\r\n");
      out.write("              </button>\r\n");
      out.write("           </div>\r\n");
      out.write("       </div>    \r\n");
      out.write("       <!-- 회원목록 끝 -->    \r\n");
      out.write("       \r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- body end -->\r\n");
      out.write("    <!-- footer start -->\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("  <div class=\"navbar navbar-expand-sm  bg-dark justify-content-center\">\r\n");
      out.write("    <a class=\"navbar-brand\"  style=\"color:white\" href=\"#\">TerrGYM Copyright&copy;2023</a>\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- footer end --> \r\n");
      out.write("    <!-- ========================== [[ 회원가입 Modal ]] ========================== -->\r\n");
      out.write("    <div class=\"modal\" id=\"memberForm\">\r\n");
      out.write("      <div class=\"modal-dialog modal-dialog-centered\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("    \r\n");
      out.write("          <!-- Modal Header -->\r\n");
      out.write("          <div class=\"modal-header\">\r\n");
      out.write("            <h4 class=\"modal-title\">회원가입</h4>\r\n");
      out.write("            <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\"></button>\r\n");
      out.write("          </div>\r\n");
      out.write("    	  <!-- 서블릿에서는 doGet메서드 안에서 4가지 경우의 수를 처리해야 한다 -->\r\n");
      out.write("          <!-- Modal body -->\r\n");
      out.write("          <div class=\"modal-body\">\r\n");
      out.write("           <form id=\"f_member\" method=\"get\" action=\"./memberCRUD\">\r\n");
      out.write("           	  <input type=\"hidden\" name=\"method\" value=\"memberInsert\"/>\r\n");
      out.write("              <div class=\"form-floating mb-3 mt-3\">\r\n");
      out.write("                <input type=\"text\"  class=\"form-control\" id=\"mem_id\" name=\"mem_id\" placeholder=\"Enter 아이디\" />\r\n");
      out.write("                <label for=\"mem_id\">아이디</label>\r\n");
      out.write("              </div>          \r\n");
      out.write("              <div class=\"form-floating mb-3 mt-3\">\r\n");
      out.write("                <input type=\"text\"  class=\"form-control\" id=\"mem_pw\" name=\"mem_pw\" placeholder=\"Enter 비밀번호\" />\r\n");
      out.write("                <label for=\"mem_pw\">비밀번호</label>\r\n");
      out.write("              </div>          \r\n");
      out.write("              <div class=\"form-floating mb-3 mt-3\">\r\n");
      out.write("                <input type=\"text\"  class=\"form-control\" id=\"mem_name\" name=\"mem_name\" placeholder=\"Enter 이름\" />\r\n");
      out.write("                <label for=\"mem_name\">이름</label>\r\n");
      out.write("              </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("				<div class=\"input-group\">\r\n");
      out.write("					<input type=\"text\" class=\"form-control\"  id=\"mem_zipcode\"  name=\"mem_zipcode\"  placeholder=\"우편번호\">\r\n");
      out.write("					<input type=\"button\" class=\"btn btn-success\"  onclick=\"zipcodeForm()\" value=\"우편번호찾기\">\r\n");
      out.write("				</div>\r\n");
      out.write("				<div style=\"margin-bottom:5px;\"></div>\r\n");
      out.write("					<input type=\"text\" class=\"form-control\"  id=\"mem_address\"  name=\"mem_address\"  placeholder=\"주소\">\r\n");
      out.write("					</form>\r\n");
      out.write("          </div>\r\n");
      out.write("    \r\n");
      out.write("          <!-- Modal footer -->\r\n");
      out.write("          <div class=\"modal-footer\">\r\n");
      out.write("            <input type=\"button\" class=\"btn btn-warning\" data-bs-dismiss=\"modal\" onclick=\"memberInsert()\" value=\"저장(가입)\">\r\n");
      out.write("          <!-- <button type=\"button\" class=\"btn btn-warning\" data-bs-dismiss=\"modal\">Add</button> -->\r\n");
      out.write("            <button type=\"button\" class=\"btn btn-danger\" data-bs-dismiss=\"modal\">Close</button>\r\n");
      out.write("          </div>\r\n");
      out.write("    \r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- ========================== [[ 회원가입 Modal ]] ========================== -->    \r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
