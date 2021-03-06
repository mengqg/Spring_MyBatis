package com.sylas.day06.part1.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmpMapper implements RowMapper<Emp>{

	@Override
	public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
		Emp emp = new Emp();
		emp.setEmpno(rs.getInt("EMPNO"));
		emp.setEname(rs.getString("ENAME"));
		emp.setJob(rs.getString("JOB"));
		emp.setMgr(rs.getInt("MGR"));
		emp.setHiredate(rs.getDate("HIREDATE"));
		emp.setSal(rs.getDouble("SAL"));
		emp.setComm(rs.getDouble("COMM"));
		emp.setDeptno(rs.getInt("DEPTNO"));
		return emp;
	}
}
