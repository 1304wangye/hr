package com.icss.hr.analysis.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.icss.hr.analysis.dao.AnaDao;

/**
 * Êý¾Ý·ÖÎö
 * @author DLETC
 *
 */
public class AnaService {

	private AnaDao dao = new AnaDao();
	
	public List<HashMap<String, Object>> queryEmpCount() throws SQLException {
		return dao.queryEmpCount();
	}
	
	public List<HashMap<String, Object>> queryEmpSalAvg() throws SQLException {
		return dao.queryEmpSalAvg();
	}
	
	public List<HashMap<String, Object>> queryEmpSal() throws SQLException {
		return dao.queryEmpSal();
	}
	
}
