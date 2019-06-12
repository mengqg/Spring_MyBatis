package com.sylas.day07.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.sylas.day07.entity.Dept;

public class TestPage {
	@Test
	public void testFindPage() throws IOException {
		String conf = "SqlMapConfig.xml";
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		Reader reader = Resources.getResourceAsReader(conf);
		SqlSessionFactory ssf = ssfb.build(reader);
		SqlSession sqlSession = ssf.openSession();
		int offset = 0;//起点,指定抓取记录的起始行,从0开始
		int limit = 2;//查几条:指定抓取记录的数量
		RowBounds rowBounds = new RowBounds(offset, limit);
		/** sqlSession.selectList(SQL的ID,参数,RowBounds对象); */
		List<Dept> list = sqlSession.selectList("findAll",null,rowBounds);
		for(Dept dept : list) {
			System.out.println(dept.getDeptno() + ";"+dept.getDname()+";"+dept.getLoc());
		}
		sqlSession.close();
	}

}
