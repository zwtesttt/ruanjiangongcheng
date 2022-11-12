package com.zw.employee.service;

import com.zw.domain.Employee;

import java.util.List;

public interface EmployeeService {
    int insertEmployee(Employee employee);

    List<Employee> queryEmployees();

    int deleteEmployee(String eid);

    Employee selectEmployeeById(String eid);

    int updateEmployee(Employee employee);

    List<Employee> selectEmployeeList(String[] eids);
}
