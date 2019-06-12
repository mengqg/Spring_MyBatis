package com.sylas.day06.part1.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.sylas.day06.part1.entity.Emp;
import com.sylas.day06.part1.entity.EmpMapper;
/**
 * @author Sylas
 */
public class JdbcEmpDAO2 implements EmpDAO{
	private JdbcTemplate template;
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public void save(Emp emp) {
		String sql = " UPDATE T_EMP SET "
				+ "ENAME = ?,"
				+ "JOB = ?,"
				+ "MGR = ?,"
				+ "HIREDATE = ?,"
				+ "SAL=?,"
				+ "COMM = ?,"
				+ "DEPTNO = ? "
				+ "WHERE EMPNO = ?";
		Object[] params = {
				emp.getEname(),
				emp.getJob(),
				emp.getMgr(),
				emp.getHiredate(),
				emp.getSal(),
				emp.getComm(),
				emp.getDeptno(),
				emp.getEmpno()
		};
		template.update(sql, params);
	}

	@Override
	public void update(Emp emp) {
		String sql = " UPDATE T_EMP SET "
				+ "ENAME = ?,"
				+ "JOB = ?,"
				+ "MGR = ?,"
				+ "HIREDATE = ?,"
				+ "SAL=?,"
				+ "COMM = ?,"
				+ "DEPTNO = ? "
				+ "WHERE EMPNO = ?";
		Object[] params = {
				emp.getEname(),
				emp.getJob(),
				emp.getMgr(),
				emp.getHiredate(),
				emp.getSal(),
				emp.getComm(),
				emp.getDeptno(),
				emp.getEmpno()
		};
		template.update(sql, params);
	}

	@Override
	public void delete(int no) {
		String pSql = " DELETE T_EMP WHERE EMPNO = ? ";
		Object[] params = {no};
		template.update(pSql, params);
	}

	@Override
	public Emp findByNo(int no) {
		String sql = " SELECT * FROM T_EMP WHERE EMPNO = ? ";
		Object[] params = {no};
		RowMapper<Emp> rowMapper = new EmpMapper();
		Emp emp = template.queryForObject(sql, params, rowMapper);
		return emp;
	}

	@Override
	public List<Emp> findAll() {
		String sql = " SELECT * FROM T_EMP ";
		RowMapper<Emp> rowMapper = new EmpMapper();
		List<Emp> list = template.query(sql, rowMapper);
		return list;
	}
	
}
