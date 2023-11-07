package com.test;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
@Controller
public class MyController {
 @Autowired
 EmployeeJdbcTemplate e1;
 
 
 @RequestMapping("/Home")
 public ModelAndView HomePage(){
 ModelAndView m1=new ModelAndView("/jsp/Testing.jsp");
 List<EmployeePojo>allemp=e1.listEmployees();
 m1.addObject("xyz",allemp);
 return m1;
 }
 
 
 @RequestMapping(value = "/Delete", method = RequestMethod.GET)
 public ModelAndView Delete(HttpServletRequest request){
 int eid = Integer.parseInt(request.getParameter("id"));
 e1.Delete(eid);
 return new ModelAndView("redirect:/Home");
 }
 
 
 @RequestMapping(value = "/Edit", method = RequestMethod.GET)
 public ModelAndView Edit(HttpServletRequest request){
 int eid = Integer.parseInt(request.getParameter("id"));
 EmployeePojo myemployee=e1.getEmployeeByID(eid);
 ModelAndView m1=new ModelAndView("/jsp/EditRecord.jsp");
 m1.addObject("eid",myemployee.getEid());
 m1.addObject("ename",myemployee.getEname());
 m1.addObject("esalary",myemployee.getEsalary());
 return m1;
 }
 
 
 @RequestMapping(value = "/Update", method = RequestMethod.POST)
 public ModelAndView Update(HttpServletRequest request){
 int eid = Integer.parseInt(request.getParameter("t1"));
 String ename=request.getParameter("t2");
 int esalary=Integer.parseInt(request.getParameter("t3"));
 e1.UpdateByEmployeeID(eid, ename, esalary);
 return new ModelAndView("redirect:/Home");
 }
 
 
 @RequestMapping("/Add")
 public ModelAndView Add(){
 ModelAndView m1=new ModelAndView("/jsp/Add.html");
 return m1;
 }
 
 
 @RequestMapping(value="/AddNew", method=RequestMethod.POST)
 public ModelAndView AddNew(HttpServletRequest request){
 int eid = Integer.parseInt(request.getParameter("t1"));
 String ename=request.getParameter("t2");
 int esalary=Integer.parseInt(request.getParameter("t3"));
 e1.addNewEmployee(eid, ename, esalary);
 return new ModelAndView("redirect:/Home");
 }
}

