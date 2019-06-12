package com.sylas.day07.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.sylas.day07.entity.Dept;
import com.sylas.day07.entity.DeptMapper;

public class TestDeptMapper {
	
	@Test
	public void testDelete() throws Exception {
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		SqlSessionFactory ssf = ssfb.build(Resources.getResourceAsReader("SqlMapConfig.xml"));
		SqlSession session = ssf.openSession();
		DeptMapper deptMapper = session.getMapper(DeptMapper.class);
		deptMapper.deleteDept(80);
		session.commit();
		session.close();
	}
	@Test
	public void testInsert() throws IOException {
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		SqlSessionFactory ssf = ssfb.build(Resources.getResourceAsReader("SqlMapConfig.xml"));
		SqlSession sqlSession = ssf.openSession();
		DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
		Dept dept = new Dept();
		dept.setDeptno(80);
		dept.setDname("testMapper");
		dept.setLoc("济南");
		deptMapper.addDept(dept);
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testFindAll() throws Exception {
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		SqlSessionFactory ssf = ssfb.build(Resources.getResourceAsReader("SqlMapConfig.xml"));
		SqlSession sqlSession = ssf.openSession();
		DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
		List<Dept> list = deptMapper.findAll();
		for(Dept dept : list) {
			System.out.println(dept.getDeptno() + ";"+dept.getDname()+";"+dept.getLoc());
		}
		sqlSession.close();
	}
}
