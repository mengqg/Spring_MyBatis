package com.sylas.day08.part1.mapper;

import java.util.List;

import com.sylas.day08.part1.annotation.MyBatisRepository;
import com.sylas.day08.part1.entity.Dept;

@MyBatisRepository
public interface DeptMapper {
	
	public List<Dept> findAll();
	
}
