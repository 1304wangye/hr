package com.icss.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.icss.hr.job.dao.JobDao;
import com.icss.hr.job.pojo.Job;

/**
 * ְ��dao������
 * 
 * @author DLETC
 *
 */
public class TestJobDao {

	private JobDao dao = new JobDao();

	// ���Բ���
	@Test
	public void testInsert() throws SQLException {
		Job job = new Job("���ž���", 50000, 20000);
		dao.insert(job);
	}

	// �����޸�
	@Test
	public void testUpdate() throws SQLException {
		Job job = new Job(2, "����", 5000, 2000);
		dao.update(job);
	}

	// ����ɾ��
	@Test
	public void testDelete() throws SQLException {
		dao.delete(1);
	}

	// ���Բ�ѯ��������
	@Test
	public void testQueryById() throws SQLException {
		Job job = dao.queryById(2);
		System.out.println(job);
	}

	// ���Բ�ѯ��������
	@Test
	public void testQuery() throws SQLException {
		List<Job> list = dao.query();
		for (Job job : list) {
			System.out.println(job);
		}
	}

}
