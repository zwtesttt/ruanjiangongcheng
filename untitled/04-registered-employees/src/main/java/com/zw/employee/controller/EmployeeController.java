package com.zw.employee.controller;


import com.zw.api.openfeign.PerformanceFeign;
import com.zw.domain.Employee;
import com.zw.domain.ResponseCode;
import com.zw.domain.ResponseObject;
import com.zw.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@Controller
public class EmployeeController {
    /**
     * 注入service对象
     */
    @Autowired
    private EmployeeService employeeService;
    /**
     * 注入远程接口对象
     */
    @Autowired
    private PerformanceFeign performanceFeign;

    //跳转录入员工页
    @GetMapping("/registered")
    public String registered(){
        return "registered";
    }

    //跳转员工列表页
    @GetMapping("/todetail")
    public String todetail(){
        return "detail";
    }

//    跳转更新员工信息页
    @GetMapping("/tomodify")
    public String tomodify(){
        return "modify";
    }


    /**
     * 录入员工
     * @param employee
     * @return
     */
    @PostMapping("/toRegistered")
    @ResponseBody
    public Object registeredEmployee(Employee employee) {
        ResponseObject re = new ResponseObject();
        try {
            //判断是否传入对象
            if (employee !=null){
                //设置uuid
                employee.setEid(UUID.randomUUID().toString().replaceAll("-", ""));
                int stu = employeeService.insertEmployee(employee);
                if (stu!=0){
                    re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_CG);
                    re.setMessage("录入员工成功");
                }else{
                    re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_SB);
                    re.setMessage("录入员工失败");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_SB);
            re.setMessage("录入员工失败");
        }
        return re;
    }

    //查询员工列表
    @GetMapping("/getEmployees")
    @ResponseBody
    public List<Employee> getEmployees(){
        return employeeService.queryEmployees();
    }


//    删除员工
    @GetMapping("/deleteEmployee/{eid}")
    public String deleteEmployee(@PathVariable String eid){
        ResponseObject re=new ResponseObject();
        try {
            if (employeeService.selectEmployeeById(eid)!=null){
                //删除员工的具体表现情况记录
                performanceFeign.deletePerformance(eid);
                int stu=employeeService.deleteEmployee(eid);
                if (stu!=0){
                    re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_CG);
                    re.setMessage("删除员工成功");
                }else{
                    re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_SB);
                    re.setMessage("删除员工失败");
                }
            }else{
                re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_SB);
                re.setMessage("删除员工失败");
            }

        }catch (Exception e){
            e.printStackTrace();
            re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_SB);
            re.setMessage("删除员工失败");
        }
        return "detail";
    }

    /**
     * 根据id查询员工
     */
    @GetMapping("/getEmployee")
    @ResponseBody
    public Employee getEmployee(@RequestParam String eid){
        return employeeService.selectEmployeeById(eid);
    }

    /**
     * 修改员工信息
     */
    @PostMapping("/updateEmployee")
    @ResponseBody
    public Object updateEmployee(Employee employee){
        ResponseObject re=new ResponseObject();
        if (employee!=null){
            try{
                int stu=employeeService.updateEmployee(employee);
                if (stu!=0){
                    re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_CG);
                    re.setMessage("修改成功");
                }else{
                    re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_SB);
                    re.setMessage("修改失败");
                }
            }catch (Exception e){
                e.printStackTrace();
                re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_SB);
                re.setMessage("修改失败");
            }
        }

        return re;
    }

    /**
     * 根据员工号获取员工信息
     * @param eids
     * @return
     */
    @PostMapping("/getEmployeeList")
    @ResponseBody
    public List<Employee> getEmployeeList(@RequestBody String[] eids){
        return employeeService.selectEmployeeList(eids);
    }



}
