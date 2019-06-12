package com.sylas.day08.part1.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sylas.day08.part1.entity.Dept;
import com.sylas.day08.part1.mapper.DeptMapper;

public class TestDeptMapper {
	@Test
	public void testScanFindAll() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-scan.xml");
		DeptMapper deptMapper = ac.getBean("deptMapper", DeptMapper.class);
		List<Dept> list = deptMapper.findAll();
		for(Dept dept : list) {
			System.out.println(dept.getDeptno() + ";"+dept.getDname()+";"+dept.getLoc());
		}
	}
	
	@Test
	public void testDeptMapper() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		DeptMapper deptMapper = ac.getBean("deptMapper", DeptMapper.class);
		List<Dept> list = deptMapper.findAll();
		for(Dept dept : list) {
			System.out.println(dept.getDeptno() + ";"+dept.getDname()+";"+dept.getLoc());
		}
	}
}
