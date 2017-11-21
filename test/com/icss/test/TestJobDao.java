package com.icss.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.icss.hr.job.dao.JobDao;
import com.icss.hr.job.pojo.Job;

/**
 * 职务dao测试类
 * 
 * @author DLETC
 *
 */
public class TestJobDao {

	private JobDao dao = new JobDao();

	// 测试插入
	@Test
	public void testInsert() throws SQLException {
		Job job = new Job("部门经理", 50000, 20000);
		dao.insert(job);
	}

	// 测试修改
	@Test
	public void testUpdate() throws SQLException {
		Job job = new Job(2, "经理", 5000, 2000);
		dao.update(job);
	}

	// 测试删除
	@Test
	public void testDelete() throws SQLException {
		dao.delete(1);
	}

	// 测试查询单条数据
	@Test
	public void testQueryById() throws SQLException {
		Job job = dao.queryById(2);
		System.out.println(job);
	}

	// 测试查询多条数据
	@Test
	public void testQuery() throws SQLException {
		List<Job> list = dao.query();
		for (Job job : list) {
			System.out.println(job);
		}
	}

}
