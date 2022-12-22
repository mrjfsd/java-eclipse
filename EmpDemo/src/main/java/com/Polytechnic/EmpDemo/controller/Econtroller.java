package com.Polytechnic.EmpDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Polytechnic.EmpDemo.model.Edemo;
import com.Polytechnic.EmpDemo.repository.Emrepo;

@Controller
public class Econtroller {

	@Autowired
	Emrepo emrepo;
	@RequestMapping("index")
	public String index()
	{
		return "index.jsp";
	}
	
	@RequestMapping("addEmp")
	public String addEmp(Edemo edemo)
	{
		emrepo.save(edemo);
		return "index.jsp";
	}
	
	@RequestMapping("getEmp")
	public ModelAndView getEmp(@RequestParam int id)
	{
		ModelAndView mv = new ModelAndView("disemply.jsp");
		Edemo edemo=emrepo.findById(id).orElse(new Edemo());
		mv.addObject(edemo);
		return mv;
	}
	
	
	@RequestMapping("deleteEmp")
	public ModelAndView deleteEmp(@RequestParam int id)
	{
		ModelAndView mv = new ModelAndView("deletedDisplay.jsp");
		Edemo edemo=emrepo.findById(id).orElse(new Edemo());
		emrepo.deleteById(id);
		mv.addObject(edemo);
		return mv;
	}
	
	@RequestMapping("UpdateEmp")
	public ModelAndView updateEmp(Edemo edemo)
	{
		ModelAndView mv = new ModelAndView("UpdateEmployee.jsp");
		edemo=emrepo.findById(edemo.getId()).orElse(new Edemo());
		mv.addObject(edemo);
		return mv;
	}
	
}










