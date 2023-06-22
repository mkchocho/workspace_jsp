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

public class DeptController extends MultiActionController{
	Logger logger = 
			Logger.getLogger(DeptController.class);
	public DeptLogic deptLogic = null;
	public void setDeptLogic(DeptLogic deptLogic) {
		this.deptLogic = deptLogic;
	}
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





















