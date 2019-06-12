package com.sylas.day07.test;

import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.sylas.day07.entity.Dept1;

public class TestResultMap {
	@Test
	public void testFindAllMapper() throws Exception {
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		SqlSessionFactory ssf = ssfb.build(Resources.getResourceAsReader("SqlMapConfig.xml"));
		SqlSession session  = ssf.openSession();
		List<Dept1> list = session.selectList("findAll1");
		for(Dept1 dept1 : list) {
			System.out.println(dept1.getName() + ";"+dept1.getNo()+";"+dept1.getLoc());
		}
		session.close();
	}
	@Test
	public void testFindAll() throws Exception {
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		SqlSessionFactory ssf = ssfb.build(Resources.getResourceAsReader("SqlMapConfig.xml"));
		SqlSession session  = ssf.openSession();
		List<Dept1> list = session.selectList("findAll1");
		for(Dept1 dept1 : list) {
			System.out.println(dept1.getName() + ";"+dept1.getNo()+";"+dept1.getLoc());
		}
		session.close();
	}
}
