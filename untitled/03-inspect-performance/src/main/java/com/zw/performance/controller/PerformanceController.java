package com.zw.performance.controller;

import com.zw.api.openfeign.EmployeeFeign;
import com.zw.domain.Employee;
import com.zw.domain.Performance;
import com.zw.domain.ResponseCode;
import com.zw.domain.ResponseObject;
import com.zw.domain.tools.UuidTools;
import com.zw.performance.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;

    @Resource
    private EmployeeFeign employeeFeign;


//    跳转员工列表页
    @GetMapping("/toPerformance")
    public String toPerformance(){
        return "performance";
    }

    /**
     * 跳转员工表现情况页
     */
    @GetMapping("/showperformance")
    public String showperformance(){
        return "showperformance";
    }

    /**
     * 调用员工模块接口查询员工
     * @return
     */
    @GetMapping("/getEmployees")
    @ResponseBody
    public List<Employee> getEmployees(){
        return employeeFeign.getEmployees();
    }

    /**
     * 跳转修改员工表现页
     */
    @GetMapping("/toModifyPerformance")
    public String toModifyPerformance(){
        return "modifyPerformance";
    }

    /**
     * 接收添加员工具体表现请求
     */
    @PostMapping("/addPerformance")
    @ResponseBody
    public Object addPerformance(Performance performance){
        ResponseObject re=new ResponseObject();
        try{
            if (performance!=null){
//                设置表现id
                performance.setPid(UuidTools.generateShortUuid());
//                设置录入时间
                performance.setRecordTime(new Date());
                int stu=performanceService.insertPerformance(performance);
                if (stu!=0){
                    re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_CG);
                    re.setMessage("录入成功");
                }else{
                    re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_SB);
                    re.setMessage("录入失败");
                }
            }else{
                re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_SB);
                re.setMessage("录入失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_SB);
            re.setMessage("录入失败");
        }
        return re;
    }

    /**
     * 接收查询员工具体表现情况请求
     */
    @GetMapping("/selectPerformance")
    @ResponseBody
    public Performance selectPerformance(@RequestParam String eid){
        return performanceService.selectPerformanceById(eid);
    }

    /**
     * 接收删除员工所有具体表现情况请求
     */
    @PostMapping("/deletePerformance")
    @ResponseBody
    public Object deletePerformance(@RequestParam String eid){
        ResponseObject re=new ResponseObject();
        try {
            int stu=performanceService.deletePerformance(eid);
            if (stu!=0){
                re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_CG);
                re.setMessage("删除成功");
            }else {
                re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_SB);
                re.setMessage("删除失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_SB);
            re.setMessage("删除失败");
        }
        return re;
    }

    /**
     * 删除员工一条具体表现情况的请求
     */
    @DeleteMapping("/deletePerformanceByPid")
    @ResponseBody
    public Object deletePerformanceByPid(String pid){
        ResponseObject re=new ResponseObject();
        try {
            int stu=performanceService.deletePerformanceByPid(pid);
            if (stu!=0){
                re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_CG);
                re.setMessage("删除成功");
            }else {
                re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_SB);
                re.setMessage("删除失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_SB);
            re.setMessage("删除失败");
        }
        return re;
    }

    /**
     * 修改员工具体表现情况记录
     */
    @PostMapping("/updatePerformance")
    @ResponseBody
    public Object updatePerformance(Performance performance){
        ResponseObject re=new ResponseObject();
        try {
            if (performance!=null){
                int stu=performanceService.updatePerformanceByPid(performance);
                if (stu!=0){
                    re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_CG);
                    re.setMessage("修改成功");
                }else {
                    re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_SB);
                    re.setMessage("修改失败");
                }
            }else{
                re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_SB);
                re.setMessage("修改失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_SB);
            re.setMessage("修改失败");
        }
        return re;
    }

    /**
     * 接收根据pid查询具体表现记录请求
     */
    @GetMapping("/getPerformanceByPid")
    @ResponseBody
    public Performance getPerformanceByPid(String pid){
        return performanceService.selectPerformanceByPid(pid);
    }

}
