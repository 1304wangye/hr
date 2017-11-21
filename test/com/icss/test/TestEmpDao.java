package com.icss.test;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.icss.hr.common.Pager;
import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.emp.dao.EmpDao;
import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.job.pojo.Job;

/**
 * 员工dao测试
 * 
 * @author DLETC
 *
 */
public class TestEmpDao {

	private EmpDao dao = new EmpDao();

	// 测试插入
	@Test
	public void testInsert() throws SQLException {

		Dept dept = new Dept();
		dept.setDeptId(21);

		Job job = new Job();
		job.setJobId(2);

		Emp emp = new Emp("tom", "tom", "123456", "tom@163.com", "13012345678", 3600, Date.valueOf("1995-10-21"), dept,
				job, null, "精通Java，oracle");

		dao.insert(emp);

	}
	
	@Test
	public void testInsertMany() throws SQLException {

		Dept dept = new Dept();
		dept.setDeptId(21);

		Job job = new Job();
		job.setJobId(2);

		for (int i = 1; i <= 20; i++) {
			Emp emp = new Emp("tom"+i, "tom"+i, "123456", "tom@163.com", "13012345678", 4700, Date.valueOf("2000-10-1"), dept,
					job, null, "精通Java，oracle");

			dao.insert(emp);
		}

	}

	// 测试修改
	@Test
	public void testUpdate() throws SQLException {

		Dept dept = new Dept();
		dept.setDeptId(21);

		Job job = new Job();
		job.setJobId(2);

		Emp emp = new Emp(1, "rose", "tom", "123456", "tom@163.com", "13012345678", 3600, Date.valueOf("1995-10-21"),
				dept, job, null, "精通Java，oracle");

		dao.update(emp);

	}

	// 测试删除
	@Test
	public void testDelete() throws SQLException {
		dao.delete(1);
	}

	// 测试查询单条数据
	@Test
	public void testQueryById() throws SQLException {
		Emp emp = dao.queryById(2);
		System.out.println(emp);
	}

	// 测试登录
	@Test
	public void testQueryByLoginName() throws SQLException {
		Emp emp = dao.queryByLoginName("tom");
		System.out.println(emp);
	}
	
	@Test
	public void testGetCount() throws SQLException {
		int count = dao.getCount();
		System.out.println(count);
	}
	
	@Test
	public void testQueryByPage() throws SQLException {
		Pager pager = new Pager(dao.getCount(), 10, 1);
		
		List<Emp> list = dao.queryByPage(pager);
		
		for (Emp emp : list) {
			System.out.println(emp);
		}
		
	}
	
	@Test
	public void testUpdateEmpPic() throws SQLException{
		dao.updateEmpPic("tom", "aaaaaaaaaaaa");
	}

}
