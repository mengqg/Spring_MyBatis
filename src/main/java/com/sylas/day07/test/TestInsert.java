package com.sylas.day07.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.sylas.day07.entity.Dept;

public class TestInsert {
	@Test
	public void testInsert() throws IOException {
		String conf = "SqlMapConfig.xml";
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		Reader reader = Resources.getResourceAsReader(conf);
		SqlSessionFactory ssf = ssfb.build(reader);
		SqlSession sqlSession = ssf.openSession();
		//调用addDept操作
		Dept dept = new Dept();
		dept.setDeptno(70);
		dept.setDname("testing");
		dept.setLoc("beijing");
		sqlSession.insert("addDepts", dept);
		sqlSession.commit();
		//关闭sqlSession
		sqlSession.close();
	}
}
