package com.icss.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.icss.hr.dept.dao.DeptDao;
import com.icss.hr.dept.pojo.Dept;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 测试部门数据访问功能
 * 
 * @author DLETC
 *
 */
public class TestDeptDao {

	private DeptDao dao = new DeptDao();

	// 测试插入
	@Test
	public void testInsert() throws SQLException {

		Dept dept = new Dept("财务部", "北京");
		dao.insert(dept);

	}

	// 测试修改
	@Test
	public void testUpdate() throws Exception {

		Dept dept = new Dept(21, "会计部", "大连");
		dao.update(dept);
	}

	// 测试删除
	@Test
	public void testDelete() throws Exception {

		dao.delete(1);
	}

	// 测试查询单条数据
	@Test
	public void testQueryById() throws Exception {

		Dept dept = dao.queryById(1);
		System.out.println(dept);

	}

	// 测试查询多条数据
	@Test
	public void testQuery() throws Exception {

		List<Dept> list = dao.query();
		for (Dept dept : list) {
			System.out.println(dept);
		}

	}

}
