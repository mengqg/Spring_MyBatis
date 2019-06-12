package com.sylas.day06.part2.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sylas.day06.part2.dao.EmpDAO;
import com.sylas.day06.part2.entity.Emp;

public class Test1 {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmpDAO empDao = ac.getBean("jdbcEmpDAO", EmpDAO.class);
		List<Emp> list = empDao.findAll();
		for(Emp emp : list) {
			System.out.println(emp.getEmpno() + ":" + emp.getEname());
		}
	}
}
