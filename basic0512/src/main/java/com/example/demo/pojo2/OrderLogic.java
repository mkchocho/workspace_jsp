package com.example.demo.pojo2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class OrderLogic {
Logger logger = Logger.getLogger(OrderLogic.class);
OrderDao orderDao = new OrderDao();
	public List<Map<String, Object>> orderList(Map<String, Object> pMap) {
		logger.info("orderList호출");
		List<Map<String, Object>> oList = null;
		oList=orderDao.orderList(pMap);
		return oList;
	}

	public int orderInsert(Map<String, Object> pMap) {
		logger.info("orderInsert호출");
		int result = -1;
		result = orderDao.orderInsert(pMap);
		return result;
	}
	public int orderUpdate(Map<String, Object> pMap) {
		logger.info("orderUpdate호출");
		int result = -1;
		result = orderDao.orderUpdate(pMap);
		return result;
	}
	public int orderDelete(Map<String, Object> pMap) {
		logger.info("orderDelete호출");
		int result = -1;
		result = orderDao.orderDelete(pMap);
		return result;
	}

}
