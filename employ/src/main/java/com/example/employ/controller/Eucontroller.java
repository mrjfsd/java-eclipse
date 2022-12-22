package com.example.employ.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.employ.model.Euser;
import com.example.employ.repository.Erepository;

@Controller
public class Eucontroller {
	@Autowired
	Erepository erep;
  @RequestMapping("index")
  public String index() {
	  return "index.jsp";
  }
  
  @RequestMapping("addEu")
  public String addEu(Euser eu) {
	  erep.save(eu);
	  return "sucess.jsp";
  }
  @RequestMapping("getSuc")
  public String getSuc() {
	  return "index.jsp";
  }
  @RequestMapping("getEu")
  public ModelAndView getEu(@RequestParam int id) {
	  ModelAndView mv = new ModelAndView("displayeu.jsp");
	  Euser eu=erep.findById(id).orElse(new Euser());
	  mv.addObject(eu);
	  return mv;
  }
  @RequestMapping("deleu")
  public ModelAndView deleu(@RequestParam int id) {
  ModelAndView mv = new ModelAndView("deldisplay.jsp");
  Euser eu =erep.findById(id).orElse(new Euser());
  erep.deleteById(id);
  mv.addObject(eu);
  return mv;
  }
   @RequestMapping("getUpdate")
   public ModelAndView getUpdate(Euser eu) {
	   ModelAndView mv = new ModelAndView("updateeu.jsp");
	   eu=erep.findById(eu.getId()).orElse(new Euser());
	  mv.addObject(eu);
	   return mv;
   }
}
