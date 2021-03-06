package com.icss.hr.emp.service;

import java.sql.SQLException;
import java.util.List;

import com.icss.hr.common.Pager;
import com.icss.hr.emp.dao.EmpDao;
import com.icss.hr.emp.pojo.Emp;

/**
 * 员工业务
 * 
 * @author DLETC
 *
 */
public class EmpService {

	private EmpDao dao = new EmpDao();

	/**
	 * 传入用户名密码，验证用户登录
	 * 
	 * @param empLoginName
	 *            用户名
	 * @param empPwd
	 *            密码
	 * @return 返回1代表用户不存在 返回2代表密码错误 返回3代表登录成功
	 * @throws SQLException
	 */
	public int checkLogin(String empLoginName, String empPwd) throws SQLException {

		Emp emp = dao.queryByLoginName(empLoginName);

		if (emp == null) {
			return 1;
		} else if (!empPwd.equals(emp.getEmpPwd())) {
			return 2;
		} else {
			return 3;
		}

	}

	// 插入数据
	public void addEmp(Emp emp) throws SQLException {
		dao.insert(emp);
	}

	// 修改数据
	public void updateEmp(Emp emp) throws SQLException {
		dao.update(emp);
	}

	// 删除数据
	public void deleteEmp(int empId) throws SQLException {
		dao.delete(empId);
	}

	// 查询单个
	public Emp queryEmpById(int empId) throws SQLException {
		return dao.queryById(empId);
	}

	// 分页查询
	public List<Emp> queryEmpByPage(Pager pager) throws SQLException {
		return dao.queryByPage(pager);
	}

	// 登录查询
	public Emp queryEmpByLoginName(String empLoginName) throws SQLException {
		return dao.queryByLoginName(empLoginName);
	}

	// 查询总记录数
	public int getEmpCount() throws SQLException {
		return dao.getCount();
	}

	//修改密码
	public void updateEmpPwd(Emp emp) throws SQLException {
		dao.updatePwd(emp);
	}
	
	//修改头像
	public void updateEmpPic(String empLoginName,String empPic) throws SQLException {
		dao.updateEmpPic(empLoginName, empPic);;
	}

}
