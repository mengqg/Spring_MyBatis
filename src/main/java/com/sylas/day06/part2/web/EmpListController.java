package com.sylas.day06.part2.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sylas.day06.part2.dao.EmpDAO;
import com.sylas.day06.part2.entity.Emp;

@Controller
public class EmpListController {
	public EmpDAO empDao;
	@Autowired
	public void setEmpDao(EmpDAO empDao) {
		this.empDao = empDao;
	}
	
	@RequestMapping("/emp/list")
	public String execute(Model model) {
		List<Emp> list = empDao.findAll();
		model.addAttribute("emps", list);
		return "emp_list";
	}

}
