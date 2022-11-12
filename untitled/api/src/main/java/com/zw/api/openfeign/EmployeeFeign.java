package com.zw.api.openfeign;

import com.zw.domain.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "04-employee")
public interface EmployeeFeign {

    /**
     * 获取员工列表
     * @return
     */
    @GetMapping("/getEmployees")
    @ResponseBody
    List<Employee> getEmployees();

    /**
     * 查询单个员工信息
     * @param eid
     * @return
     */
    @GetMapping("/getEmployee")
    @ResponseBody
    Employee getEmployee(@RequestParam String eid);

    /**
     * 查询多个员工信息
     * @param eids
     * @return
     */
    @PostMapping("/getEmployeeList")
    @ResponseBody
    List<Employee> getEmployeeList(@RequestBody String[] eids);
}
