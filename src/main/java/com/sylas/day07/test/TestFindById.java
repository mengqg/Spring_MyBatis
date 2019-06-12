package com.sylas.day07.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.sylas.day07.entity.Dept;

public class TestFindById {
	@Test
	public void findAll() throws IOException {
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
		SqlSessionFactory ssf = ssfb.build(reader);
		SqlSession sqlSession = ssf.openSession();
		List<Dept> list = sqlSession.selectList("findAll");
		for(Dept dept : list) {
			System.out.println(dept.getDeptno() + ";"+dept.getDname()+";"+dept.getLoc());
		}
	}
	
	@Test
	public void findById() throws IOException {
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
		SqlSessionFactory ssf = ssfb.build(reader);
		SqlSession sqlSession = ssf.openSession();
		Dept dept = sqlSession.selectOne("findById",10);
		System.out.println(dept.getDeptno() + ";"+dept.getDname()+";"+dept.getLoc());
		sqlSession.close();
	}
}
