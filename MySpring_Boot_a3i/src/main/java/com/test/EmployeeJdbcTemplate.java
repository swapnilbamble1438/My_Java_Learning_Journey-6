package com.test;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
@SpringBootApplication
public class EmployeeJdbcTemplate {
 @Autowired
 JdbcTemplate jdbc;
 public List<EmployeePojo> listEmployees() {
 // TODO Auto-generated method stub
 String SQL = "select * from Emp";
 List <EmployeePojo> allemployees = jdbc.query(SQL, new EmployeeMapper());
 return allemployees;
 }
 public void Delete(int id){
 String sql="Delete from emp where eid=?";
 jdbc.update(sql,id);
 } 
 public EmployeePojo getEmployeeByID(int id){
 String sql="Select * from emp where eid=?";
 EmployeePojo e1=(EmployeePojo)jdbc.queryForObject(sql,new Object[]{id}, new
 EmployeeMapper());
 return e1;
 }
 public void UpdateByEmployeeID(int id,String ename,int esalary){
 String sql="update emp set ename=?,esalary=? where eid=?";
 jdbc.update(sql,new Object[]{ename,esalary,id});
 }
 public void addNewEmployee(int id,String ename,int esalary){
 String sql="insert into emp values(?,?,?)";
 jdbc.update(sql,new Object[]{id,ename,esalary});
 }
}
