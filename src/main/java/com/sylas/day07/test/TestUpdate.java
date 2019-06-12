package com.sylas.day07.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.sylas.day07.entity.Dept;

public class TestUpdate {
	@Test
	public void testUpdate() throws IOException {
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
		SqlSessionFactory ssf = ssfb.build(reader);
		SqlSession sqlSession = ssf.openSession();
		Dept dept = new Dept();
		dept.setDeptno(60);
		dept.setDname("开发部");
		dept.setLoc("北京");
		sqlSession.update("updateDept", dept);
		sqlSession.commit();
		sqlSession.close();
	}
}
