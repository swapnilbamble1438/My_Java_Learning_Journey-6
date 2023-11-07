package com.test;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
public class EmployeeMapper implements RowMapper
{
 public EmployeePojo mapRow(ResultSet rs, int rowNum) throws SQLException 
 {
 EmployeePojo employee = new EmployeePojo();
 employee.setEid(rs.getInt("eid"));
 employee.setEname(rs.getString("ename"));
 employee.setEsalary(rs.getInt("esalary"));
 return employee;
 }
}
