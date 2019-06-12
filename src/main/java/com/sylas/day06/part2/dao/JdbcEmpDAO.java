package com.sylas.day06.part2.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sylas.day06.part2.entity.Emp;
import com.sylas.day06.part2.entity.EmpMapper;
@Repository
public class JdbcEmpDAO implements EmpDAO{
	
	private JdbcTemplate template;
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public List<Emp> findAll() {
		String sql = " SELECT * FROM T_EMP ";
		RowMapper<Emp> rowMapper = new EmpMapper();
		List<Emp> list = template.query(sql, rowMapper);
		return list;
	}

}
