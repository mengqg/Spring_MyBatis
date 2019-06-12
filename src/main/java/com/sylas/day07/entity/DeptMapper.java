package com.sylas.day07.entity;

import java.util.List;

public interface DeptMapper {
	public void addDept(Dept dept);
	
	public void updateDept(Dept dept);
	
	public void deleteDept(int id);
	
	public Dept findById(int id);
	
	public List<Dept> findAll();
}
