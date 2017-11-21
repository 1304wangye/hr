package com.icss.hr.analysis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.icss.hr.common.DbUtil;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

/**
 * 数据分析dao
 * @author DLETC
 *
 */
public class AnaDao {

	/**
	 * 统计每个部门的员工人数
	 * @throws SQLException 
	 */
	public List<HashMap<String, Object>> queryEmpCount() throws SQLException {
		
		Connection conn = DbUtil.getConnection();
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT dept_name,COUNT(e.emp_id) emp_count ");
		sql.append("FROM   dept d ");
		sql.append("LEFT   JOIN emp e ON d.dept_id = e.emp_dept_id ");
		sql.append("GROUP  BY dept_name");
		
		PreparedStatement psmt = conn.prepareStatement(sql.toString());
		
		ResultSet rs = psmt.executeQuery();
		
		List<HashMap<String, Object>> list = new ArrayList<>();
		
		while(rs.next()){
			HashMap<String, Object> map = new HashMap<>();
			map.put("deptName", rs.getString(1));
			map.put("empCount", rs.getInt(2));
			
			list.add(map);
		}
		
		rs.close();
		psmt.close();
		conn.close();
		
		return list;
	}
	
	/**
	 * 统计每个部门员工的平均工资
	 * @throws SQLException 
	 */
	public List<HashMap<String, Object>> queryEmpSalAvg() throws SQLException {
		
		Connection conn = DbUtil.getConnection();
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT dept_name,round(AVG(e.emp_salary)) emp_sal_avg ");
		sql.append("FROM   dept d ");
		sql.append("LEFT   JOIN emp e ON d.dept_id = e.emp_dept_id ");
		sql.append("GROUP  BY dept_name");
		
		PreparedStatement psmt = conn.prepareStatement(sql.toString());
		
		ResultSet rs = psmt.executeQuery();
		
		List<HashMap<String, Object>> list = new ArrayList<>();
		
		while(rs.next()){
			HashMap<String, Object> map = new HashMap<>();
			map.put("deptName", rs.getString(1));
			map.put("empSalAvg", rs.getInt(2));
			
			list.add(map);
		}
		
		rs.close();
		psmt.close();
		conn.close();
		
		return list;
	}
	
	/**
	 * 统计每个部门员工的平均工资
	 * @throws SQLException 
	 */
	public List<HashMap<String, Object>> queryEmpSal() throws SQLException {
		
		Connection conn = DbUtil.getConnection();
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT dept_name,round(MIN(e.emp_salary)) emp_sal_min,round(MAX(e.emp_salary)) emp_sal_min ");
		sql.append("FROM   dept d ");
		sql.append("LEFT   JOIN emp e ON d.dept_id = e.emp_dept_id ");
		sql.append("GROUP  BY dept_name");
		
		PreparedStatement psmt = conn.prepareStatement(sql.toString());
		
		ResultSet rs = psmt.executeQuery();
		
		List<HashMap<String, Object>> list = new ArrayList<>();
		
		while(rs.next()){
			HashMap<String, Object> map = new HashMap<>();
			map.put("deptName", rs.getString(1));
			map.put("empSalMin", rs.getInt(2));
			map.put("empSalMax", rs.getInt(3));
			
			list.add(map);
		}
		
		rs.close();
		psmt.close();
		conn.close();
		
		return list;
	}
	
}
