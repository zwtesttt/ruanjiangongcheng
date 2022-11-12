package com.zw.employee.service;

import com.zw.domain.Employee;
import com.zw.employee.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
//    添加员工
    @Override
    public int insertEmployee(Employee employee) {
        //调用mapper方法
        return employeeMapper.registeredEmployee(employee);
    }
//    返回员工列表
    @Override
    public List<Employee> queryEmployees() {
        return employeeMapper.queryEmployee();
    }
//    根据id删除员工
    @Override
    public int deleteEmployee(String eid) {
        return employeeMapper.deleteEmployeeById(eid);
    }
    //    根据id查询员工
    @Override
    public Employee selectEmployeeById(String eid) {
        return employeeMapper.selectEmployeeById(eid);
    }

    @Override
    public int updateEmployee(Employee employee) {
        return employeeMapper.updateEmployee(employee);
    }

    @Override
    public List<Employee> selectEmployeeList(String[] eids) {
        return employeeMapper.selectEmployeeList(eids);
    }


}
