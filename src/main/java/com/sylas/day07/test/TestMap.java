package com.sylas.day07.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class TestMap {
	@Test
	public void testDepts() throws Exception {
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
		SqlSessionFactory ssf = ssfb.build(reader);
		SqlSession sqlSession = ssf.openSession();
		List<Map> list  = sqlSession.selectList("findDepts");
		for(Map map : list) {
			System.out.println(map.get("DEPTNO")+";"+map.get("DNAME")+";"+map.get("LOC"));
		}
	}
	
	@Test
	public void testMap() throws IOException {
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
		SqlSessionFactory ssf = ssfb.build(reader);
		SqlSession sqlSession = ssf.openSession();
		Map map = sqlSession.selectOne("findDept", 10);
		System.out.println(map.get("DEPTNO")+";"+map.get("DNAME")+";"+map.get("LOC"));
	}
}	
