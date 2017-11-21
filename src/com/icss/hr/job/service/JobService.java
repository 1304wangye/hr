package com.icss.hr.job.service;

import java.sql.SQLException;
import java.util.List;

import com.icss.hr.job.dao.JobDao;
import com.icss.hr.job.pojo.Job;

/**
 * 职务业务
 * 
 * @author DLETC
 *
 */
public class JobService {

	private JobDao dao = new JobDao();

	// 插入数据
	public void addJob(Job job) throws SQLException {
		dao.insert(job);
	}

	// 修改数据
	public void updateJob(Job job) throws SQLException {
		dao.update(job);
	}

	// 删除数据
	public void deleteJob(int jobId) throws SQLException {
		dao.delete(jobId);
	}

	// 查询单个
	public Job queryJobById(int jobId) throws SQLException {
		return dao.queryById(jobId);
	}

	// 查询全部
	public List<Job> queryJob() throws SQLException {
		return dao.query();
	}

}
