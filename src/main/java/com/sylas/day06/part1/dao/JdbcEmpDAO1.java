package com.sylas.day06.part1.dao;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.sylas.day06.part1.entity.Emp;
import com.sylas.day06.part1.entity.EmpMapper;

public class JdbcEmpDAO1 extends JdbcDaoSupport implements EmpDAO{

	@Override
	public void save(Emp emp) {
		String sql = " INSERT INTO T_EMP ("
				+ "EMPNO,ENAME,JOB,MGR,HIREDATE,"
				+ "SAL,COMM,DEPTNO ) "
				+ "VALUE (?,?,?,?,?"
				+ "?,?,?)";
		Object[] params = {
				emp.getEmpno(),
				emp.getEname(),
				emp.getJob(),
				emp.getMgr(),
				emp.getHiredate(),
				emp.getSal(),
				emp.getComm(),
				emp.getDeptno()
		};
		super.getJdbcTemplate().update(sql, params);
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
		super.getJdbcTemplate().update(sql, params);
	}

	@Override
	public void delete(int no) {
		String sql = "DELETE FROM T_EMP WHERE ENPNO = ?";
		Object[] params = {no};
		super.getJdbcTemplate().update(sql, params);
	}

	@Override
	public Emp findByNo(int no) {
		String sql = "SELECT * FROM T_EMP WHERE EMPNO = ? ";
		Object[] params = {no};
		RowMapper<Emp> mapper = new EmpMapper();
		Emp emp = super.getJdbcTemplate().queryForObject(sql, params, mapper);
		return emp;
	}

	@Override
	public List<Emp> findAll() {
		String sql = " SELECT * FROM T_EMP ";
		RowMapper<Emp> mapper = new EmpMapper();
		List<Emp> list = super.getJdbcTemplate().query(sql, mapper);
		return list;
	}
	
}
