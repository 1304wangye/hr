package com.icss.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.icss.hr.dept.dao.DeptDao;
import com.icss.hr.dept.pojo.Dept;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * ���Բ������ݷ��ʹ���
 * 
 * @author DLETC
 *
 */
public class TestDeptDao {

	private DeptDao dao = new DeptDao();

	// ���Բ���
	@Test
	public void testInsert() throws SQLException {

		Dept dept = new Dept("����", "����");
		dao.insert(dept);

	}

	// �����޸�
	@Test
	public void testUpdate() throws Exception {

		Dept dept = new Dept(21, "��Ʋ�", "����");
		dao.update(dept);
	}

	// ����ɾ��
	@Test
	public void testDelete() throws Exception {

		dao.delete(1);
	}

	// ���Բ�ѯ��������
	@Test
	public void testQueryById() throws Exception {

		Dept dept = dao.queryById(1);
		System.out.println(dept);

	}

	// ���Բ�ѯ��������
	@Test
	public void testQuery() throws Exception {

		List<Dept> list = dao.query();
		for (Dept dept : list) {
			System.out.println(dept);
		}

	}

}
