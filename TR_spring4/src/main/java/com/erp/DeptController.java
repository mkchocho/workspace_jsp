package com.erp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.util.HangulConversion;
import com.util.HashMapBinder;
import com.vo.DeptVO;
//@Controller를 사용하는 대신에 MultiActionController를 상속 받음 
//넌 컨트롤 계층이다 - 그래서 request와 response를 사용할 수 있다는 거지
//근데 왜 deprecated(취소선) 된 거지?
//더 이상 지원하지 않을 거야 
//문제제기 - 서블릿에 종속적이다. - 표준이지만, 별로좋지 않다 : 자유도가 떨어짐 - 단위테스트가 불가 - 다 같이 야근 
//상속을 받는다는 건 제약조건을 지켜야 함 - @Override
//메이븐이나 그레이들 통해서 플젝을 생성하면 의존관계에 있는 jar파일에 대한 부담을 덜어낸다
public class DeptController extends MultiActionController{
	Logger logger = 
			Logger.getLogger(DeptController.class);
	//@Autowired 자리- spring maven, gradle에서  
	public DeptLogic deptLogic = null;
	public void setDeptLogic(DeptLogic deptLogic) {
		this.deptLogic = deptLogic;
	}
	//HttpServlet을 상속받지 않았는데도 req와 res를 사용할 수 있다.
	//심지어 doGet이나 doPost메소드 이름과 다른데도 누릴 수 있다.
	//리턴 타입이 String이어도 괜찮아 - 자유 - 원래 doGet과 doPost void이었다.
	//언젠가는 너도 프레임워크를 만들 수 있다 - 아키텍쳐 설계 - 생성자조립, 메소드 리턴타입과 파라미터 변경가능함
	//저게 안되면 if문 안에 if문 이러고 있다 - 코드 가독성이 떨어짐 - 재사용성도 떨어짐 - 불편함
	//if문으로 분기된 코드를 메소드 중심의 코드로 변경가능함 
	//void를 나는 String으로 바꿀 수 있다.
	//String을 나는 ModelAndView로 변경 가능함 - ModelAndView를 설계
	//String
	//2) redirect:deptList.jsp
	//3) forward:deptList.jsp
	//3) deptList - ViewResolver 컨벤션을 따른다 /WEB-INF/views/화면이름.jsp
	// rdirect나 forward를 쓰면 안 됨 
	public String deptInsert(HttpServletRequest req,HttpServletResponse res)
	{
		DeptVO pdVO = new DeptVO();
		pdVO.setDeptno
		(Integer.parseInt(req.getParameter("deptno")));
		pdVO.setDname
		(HangulConversion.toKor(req.getParameter("dname")));
		pdVO.setLoc
		(HangulConversion.toKor(req.getParameter("loc")));
		int result = deptLogic.deptInsert(pdVO);
		return "dept/getDeptList";
	}
	//스프링레거시 - 공통분모 - DI, IoC - 형식 다를 뿐
	//컨트롤 클래스에서 리턴타입을 ModelAndView로 해야하는 경우는 언제일까요?
	// 1)SELECT
	// 2)화면 배치가 WEB-INF 이다
	//이렇게 상속을 통해서 메소드 선언할 때 파라미터 자리를 비우면 망함 - 호출이 안 됨
	//자꾸만 No Mapping XXX.sp4 - 원인이 뭔가요?
	//메소드의 파라미터에 request와 response를 주입받지 않고 있어서... - 못찾아 
	public ModelAndView deptList(HttpServletRequest req,HttpServletResponse res)
	{
		logger.info("deptList");
		HashMapBinder hmb = new HashMapBinder(req);
		Map<String,Object> pMap = new HashMap<>();
		hmb.bind(pMap);
		List<DeptVO> deptList = deptLogic.deptList(pMap);
		//logger.info(deptList);
		// 스프링에서 UI를 지원하는 클래임
		ModelAndView mav = new ModelAndView();
		mav.addObject("deptList", deptList);
		// ViewResolver가 개임
		// -> /WEB-INF/views 화면이름.jsp 
		// -> /WEB-INF/views/getDeptList.jsp 
		mav.setViewName("dept/getDeptList");
		//return "forward:getDeptList.jsp";
		return mav;
	}
}





















