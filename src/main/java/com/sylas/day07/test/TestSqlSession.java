package com.sylas.day07.test;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class TestSqlSession {
	@Test
	public void testSqlSession() throws Exception{
		String conf = "SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader(conf);
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		/** 创建SqlSessionFactory对象 */
		SqlSessionFactory ssf = ssfb.build(reader);
		/** 创建Session */
		SqlSession sqlSession = ssf.openSession();
		System.out.println(sqlSession);
		/** 关闭Session */
		sqlSession.close();
	}
}
