package com.zw.calculation.controller;

import com.zw.api.openfeign.EmployeeFeign;
import com.zw.api.openfeign.PerformanceFeign;
import com.zw.api.openfeign.WagesscaleFeign;
import com.zw.calculation.service.PayslipService;
import com.zw.domain.*;
import com.zw.domain.tools.DateTools;
import com.zw.domain.tools.UuidTools;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

@Controller
public class PayslipController {
    /**
     * 注入员工远程调用接口
     */
    @Autowired
    private EmployeeFeign employeeFeign;
    /**
     * 注入工资标准远程调用接口
     */
    @Autowired
    private WagesscaleFeign wagesscaleFeign;

    /**
     * 注入员工具体表现远程调用接口
     */
    @Autowired
    private PerformanceFeign performanceFeign;
    /**
     * 注入service对象
     * @return
     */
    @Autowired
    private PayslipService payslipService;

    /**
     * 跳转计算工资单页
     * @return
     */
    @GetMapping("/toPayroll")
    public String toPayroll(){
        return "payroll";
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
     * 查询单个员工的信息
     */
    @GetMapping("/getEmployee")
    @ResponseBody
    public Employee getEmployee(String eid){
        return employeeFeign.getEmployee(eid);
    }

    /**
     * 查询多个员工信息
     */
    @PostMapping("/getEmployeeList")
    @ResponseBody
    public List<Employee> getEmployeeList(@RequestBody String[] eids){
        return employeeFeign.getEmployeeList(eids);
    }

    /**
     * 查询最新的工资标准
     */
    @GetMapping("/getWagesscale")
    @ResponseBody
    public Object getWagesscale(){
        return wagesscaleFeign.getWagesscale();
    }
    /**
     * 调用远程接口查询岗位工资第一级标准
     */
    @GetMapping("/getNewJobscale")
    @ResponseBody
    public Object getNewJobscale(){
        return wagesscaleFeign.getNewJobscale();
    }

    /**
     * 调用远程接口查询员工具体表现情况
     * @param eid
     * @return
     */
    @GetMapping("/selectPerformance")
    @ResponseBody
    public Performance selectPerformance(String eid){
        return performanceFeign.selectPerformance(eid);
    }
    /**
     * 添加工资记录
     */
    @PostMapping("/addPayslip")
    @ResponseBody
    public Object addPayslip(@RequestBody Payslip[] payslip){
        ResponseObject re=new ResponseObject();
        try{
            if (payslip!=null){
                for (Payslip a:payslip
                     ) {
                    a.setId(UuidTools.generateShortUuid());
                    a.setCreatetime(new Date());
                }
                int stu=payslipService.insertPayslip(payslip);
                if (stu!=0){
                    re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_CG);
                    re.setMessage("生成成功");
                }else{
                    re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_SB);
                    re.setMessage("生成失败");
                }
            }else{
                re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_SB);
                re.setMessage("生成失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_SB);
            re.setMessage("生成失败");
        }

        return re;
    }

    /**
     * 接收导出工资条请求
     */
    @GetMapping("/downloadPayslip")
    public void downloadPayslip(HttpServletResponse response,String[] ids) throws IOException {
        HSSFWorkbook wb=new HSSFWorkbook();
        HSSFSheet sh= wb.createSheet("工资条");
        HSSFRow ro=sh.createRow(0);
        HSSFCell cell=ro.createCell(0);
        cell.setCellValue("序号");
        cell=ro.createCell(1);
        cell.setCellValue("工号");
        cell=ro.createCell(2);
        cell.setCellValue("姓名");
        cell=ro.createCell(3);
        cell.setCellValue("基本工资");
        cell=ro.createCell(4);
        cell.setCellValue("生活津贴");
        cell=ro.createCell(5);
        cell.setCellValue("绩效/计件工资");
        cell=ro.createCell(6);
        cell.setCellValue("加班工资");
        cell=ro.createCell(7);
        cell.setCellValue("岗位工资");
        cell=ro.createCell(8);
        cell.setCellValue("计算时间");
        cell=ro.createCell(9);
        cell.setCellValue("实发工资");

//      判断员工号是否为空
        if (ids!=null && ids.length>0){
            Payslip[] li= payslipService.queryPayslips(ids);
            Payslip ac=null;
            //遍历市场活动list
            for (int i=0;i<li.length;i++) {
                ac= li[i];
                ro=sh.createRow(i+1);
                cell=ro.createCell(0);
                cell.setCellValue(i+1);
                cell=ro.createCell(1);
                cell.setCellValue(ac.getEid());
                cell=ro.createCell(2);
                cell.setCellValue(ac.getEname());
                cell=ro.createCell(3);
                cell.setCellValue(ac.getBasicsalary());
                cell=ro.createCell(4);
                cell.setCellValue(ac.getAllowance());
                cell=ro.createCell(5);
                cell.setCellValue(ac.getPerformance());
                cell=ro.createCell(6);
                cell.setCellValue(ac.getOvertimesalary());
                cell=ro.createCell(7);
                cell.setCellValue(ac.getJobsalary());
                cell=ro.createCell(8);
                cell.setCellValue(DateTools.getDate(ac.getCreatetime()));
                cell=ro.createCell(9);
                cell.setCellValue(ac.getSalary());
                cell=ro.createCell(10);
//                cell.setCellValue(ac.getEdit_time());
//                cell=ro.createCell(10);
//                cell.setCellValue(ac.getEdit_by());
            }
            //设置返回值类型
            response.setContentType("application/octet-stream;charset=UTF-8");
//        获取输出流
            OutputStream out=response.getOutputStream();
            //设置响应头
            response.addHeader("Content-Disposition","attachment;filename=gongzidan.xls");
            wb.write(out);//将wb文件输出流的内容直接写入到响应输出流
            out.flush();
            wb.close();
            payslipService.deletePayslip(ids);
        }
    }
    /**
     * 根据工号删除工资单记录
     */
    @DeleteMapping("/deletePayslip")
    @ResponseBody
    public Object deletePayslip(@RequestBody String[] ids){
        ResponseObject re=new ResponseObject();
        try{
            if (ids!=null){
                int stu=payslipService.deletePayslip(ids);
                if (stu!=0){
                    re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_CG);
                    re.setMessage("删除成功");
                }else{
                    re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_SB);
                    re.setMessage("删除失败");
                }
            }else{
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

}