/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.73
 * Generated at: 2023-07-13 07:01:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class gym_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/include/gym_footer.jsp", Long.valueOf(1684303334210L));
    _jspx_dependants.put("/include/gym_header.jsp", Long.valueOf(1688607047133L));
    _jspx_dependants.put("/common/bootstrap_common.jsp", Long.valueOf(1688620159665L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>터짐</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"./css/main.css\">\r\n");
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
      out.write("<script src=\"https://developers.kakao.com/sdk/js/kakao.min.js\"></script>\r\n");
      out.write("<!-- f3fbd88572f48f2bd5fdfcb89cbc3aa0  -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"https://dapi.kakao.com/v2/maps/sdk.js?appkey=f3fbd88572f48f2bd5fdfcb89cbc3aa0\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!--======================== header start  ========================-->\r\n");
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
      out.write("       		<a class=\"nav-link\" href=\"/qna/qnaList.pj3\">QnA게시판</a>\r\n");
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
      out.write("<!--======================== header end     ========================-->\r\n");
      out.write("<!--======================== body start      ========================-->\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("	<div class=\"main_header\"></div>\r\n");
      out.write("	<div class=\"main\">\r\n");
      out.write("		<div>이벤트존</div>\r\n");
      out.write("		<hr style=\"height:2px\"/>\r\n");
      out.write("		<div>추천수업존</div>\r\n");
      out.write("		<hr style=\"height:2px\"/>\r\n");
      out.write("		<div class=\"mapwrap\">\r\n");
      out.write("			<div id=\"map\" class=\"map\"></div>\r\n");
      out.write("			<!-- <div id=\"map\" style=\"width:500px;height:400px;\"></div> -->\r\n");
      out.write("			<script type=\"text/javascript\">\r\n");
      out.write("				//console.log(document.getElementById(\"map\"));\r\n");
      out.write("				//document.querySelector(\"#map\");\r\n");
      out.write("				const container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스\r\n");
      out.write("				//배열 선언 - 마커를 여러개 표시하고 싶은 경우일 때 참고 \r\n");
      out.write("				//자바 스크립트 배열 복습 → 깊은 복사(새로운 배열 생성해서 사용함)와 얕은 복사(원본 사용함)\r\n");
      out.write("				const positions = [\r\n");
      out.write("					{\r\n");
      out.write("						content: \"<div style='padding:5px;'><h4>구디아카데미</h4><img src='./images/gudi.png'></div>\",\r\n");
      out.write("						latlng: new kakao.maps.LatLng(37.4765002, 126.8799586)\r\n");
      out.write("					}\r\n");
      out.write("				];\r\n");
      out.write("				const options = { //지도를 생성할 때 필요한 기본 옵션\r\n");
      out.write("					center: positions[0].latlng,\r\n");
      out.write("					level: 4 //지도의 레벨(확대, 축소 정도)\r\n");
      out.write("				};\r\n");
      out.write("				\r\n");
      out.write("				const map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴		\r\n");
      out.write("				\r\n");
      out.write("				//제목 :  카카오 맵에 마커 표시하기\r\n");
      out.write("				// 지도를 클릭한 위치에 표출할 마커입니다\r\n");
      out.write("				const marker = new kakao.maps.Marker({ \r\n");
      out.write("					map:map, //마커를 표시할 지도\r\n");
      out.write("				    // 지도 중심좌표에 마커를 생성합니다 \r\n");
      out.write("				    position: positions[0].latlng //마커의 위치 잡아주기\r\n");
      out.write("				}); \r\n");
      out.write("				// 마커에 표시할 인포윈도우를 생성하기\r\n");
      out.write("				const infoWindow = new kakao.maps.InfoWindow({\r\n");
      out.write("					//생성자 안에 좌중괄호 우중괄호를 붙이면 실행문 작성가능함\r\n");
      out.write("					content: positions[0].content //인포윈도우(다이얼로그창, 팝업창)에 표시할 내용\r\n");
      out.write("				});//아래코드에서 클로저를 사용할 때는 반드시 세미콜론 붙일 것.\r\n");
      out.write("				\r\n");
      out.write("				// 마커에 이벤트를 등록하는 함수 구현\r\n");
      out.write("				//구현하는 즉시 실행시키기 위해서 클로저 사용함\r\n");
      out.write("				(function(marker, infoWindow){\r\n");
      out.write("					//마커에 mouseover 이벤트를 등록하고 마우스 오버시에 인포윈도우를 표시함\r\n");
      out.write("					//@param:marker는 이벤트 소스이다 \r\n");
      out.write("					//@param:marker에 적용할 수 있는 이벤트 핸들러 이름임\r\n");
      out.write("					//@param:콜백함수-네가 마커에 마우스 오버 시키면 내가 실행을 약속할께\r\n");
      out.write("					kakao.maps.event.addListener(marker, 'mouseover', function(){\r\n");
      out.write("						infoWindow.open(map, marker);\r\n");
      out.write("					});\r\n");
      out.write("					//마커에 mouseout 이벤트를 등록하고 마우스 아웃시에 인포윈도우를 닫음\r\n");
      out.write("					kakao.maps.event.addListener(marker, 'mouseout', function(){\r\n");
      out.write("						infoWindow.close();\r\n");
      out.write("					});\r\n");
      out.write("					\r\n");
      out.write("				})(marker, infoWindow);//여기 괄호가 함수를 호출하는 코드임\r\n");
      out.write("				\r\n");
      out.write("				// 지도에 마커를 표시합니다\r\n");
      out.write("				marker.setMap(map);\r\n");
      out.write("	\r\n");
      out.write("				\r\n");
      out.write("			</script>			\r\n");
      out.write("			\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("		<hr style=\"height: 2px\" />\r\n");
      out.write("		<table class=\"table\" style=\"minWidth: 700px\">\r\n");
      out.write("			<tbody style=\"border: 1px solid lightgray\">\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td style=\"borderRight: 1px solid lightgray\">주소</td>\r\n");
      out.write("					<td>서울특별시 금천구 가산디지털2로 95 KM타워 3층 (T: 02-818-7950)</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td style=\"borderRight: 1px solid lightgray\">버스</td>\r\n");
      out.write("					<td>디지털3단지 사거리 정류장<br /> 지선 5536/5714 간선 503/504 일반 21\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td style=\"borderRight: 1px solid lightgray\">지하철</td>\r\n");
      out.write("					<td>지하철 1, 7호선 가산디지털단지역 5번출구 200m</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("			</tbody>\r\n");
      out.write("		</table>		\r\n");
      out.write("		\r\n");
      out.write("	</div>\r\n");
      out.write("	<div class=\"main_footer\"></div>\r\n");
      out.write("</div>\r\n");
      out.write("<!--======================== body end        ========================-->\r\n");
      out.write("<!--======================== footer start  ========================-->\r\n");
      out.write("\r\n");
      out.write("  <div class=\"navbar navbar-expand-sm  bg-dark justify-content-center\">\r\n");
      out.write("    <a class=\"navbar-brand\"  style=\"color:white\" href=\"#\">TerrGYM Copyright&copy;2023</a>\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("<!--======================== footer end     ========================-->\r\n");
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
