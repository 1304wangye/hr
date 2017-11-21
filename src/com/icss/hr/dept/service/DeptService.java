package com.icss.hr.dept.service;

import java.sql.SQLException;
import java.util.List;

import com.icss.hr.dept.dao.DeptDao;
import com.icss.hr.dept.pojo.Dept;

/**
 * 部门业务
 * @author DLETC
 *
 */
public class DeptService {
	private DeptDao dao = new DeptDao();
	//插入数据
	public void addDept(Dept dept) throws SQLException{
		dao.insert(dept);
	}
	//修改数据
	public void updateDept(Dept dept) throws SQLException{
		dao.update(dept);
	}
	//删除数据
	public void deleteDept(int deptId) throws SQLException{
		dao.delete(deptId);
	}
	//查询单个
	public Dept queryDeptById(int deptId) throws SQLException{
		return dao.queryById(deptId);
	}
	//查询全部
	public List<Dept> queryDept() throws SQLException{
		return dao.query();
	}

}
