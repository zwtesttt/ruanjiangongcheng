package com.zw.wagescale.controller;

import com.zw.domain.Jobscale;
import com.zw.domain.ResponseCode;
import com.zw.domain.ResponseObject;
import com.zw.domain.Wagesscale;
import com.zw.domain.tools.DateTools;
import com.zw.domain.tools.UuidTools;
import com.zw.wagescale.service.JobscaleService;
import com.zw.wagescale.service.WagesscaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class WagesscaleController {

    /**
     * 注入工资标准service对象
     */
    @Autowired
    private WagesscaleService wagesscaleService;

    /**
     * 注入岗位工资service对象
     * @return
     */
    @Autowired
    private JobscaleService jobscaleService;

    //跳转工资标准页
    @GetMapping("/toWagesscale")
    public String toWagesscale(){
        return "wagesscale";
    }
    //跳转添加工资标准页
    @GetMapping("/toAddWagesscale")
    public String toAddWagesscale(){
        return "addWagesscale";
    }

    //跳转修改工资标准页
    @GetMapping("/toModifyWagesscale")
    public String toModifyWagesscale(){
        return "modifyWagesscale";
    }

    //跳转添加岗位工资标准页
    @GetMapping("/toJobScale")
    public String toJobScale(){
        return "addJobscale";
    }

    /**
     * 跳转修改岗位工资标准页
     */
    @GetMapping("/toModifyJobScale")
    public String toModifyJobScale(){
        return "modifyJobscale";
    }
    /**
     * 添加工资标准
     * @param wagesscale
     * @return
     */
    @PostMapping("/addWagesscale")
    @ResponseBody
    public Object addWagesscale(Wagesscale wagesscale){
        ResponseObject re=new ResponseObject();
        try {
            if (wagesscale != null) {
//                设置工资标准主键id
                wagesscale.setWid(UuidTools.generateShortUuid());
//                设置创建时间
                wagesscale.setCreatetime(new Date());
                int s=wagesscaleService.addWagesscale(wagesscale);
                if (s!=0){
                    re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_CG);
                    re.setMessage("录入成功");
                }else{
                    re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_SB);
                    re.setMessage("录入失败");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_SB);
            re.setMessage("录入失败");
        }
        return re;
    }
    /**
     * 返回一条离当前时间最近的工资标准
     */
    @GetMapping("/getWagesscale")
    @ResponseBody
    public Object getWagesscale(){
        ResponseObject reo=new ResponseObject();
        Wagesscale wagesscale=wagesscaleService.queryminTime();
        if (wagesscale!=null){
            Date time=wagesscale.getCreatetime();
            String re=DateTools.getDate(time);
            reo.setCode(ResponseCode.RESPONSE_STUDENT_CODE_CG);
            reo.setMessage("查询成功");
            reo.setData(wagesscale);
        }else {
            reo.setCode(ResponseCode.RESPONSE_STUDENT_CODE_SB);
            reo.setMessage("查询失败");
        }

        return reo;
    }

    /**
     * 根据id查询工资标准
     * @param wid
     * @return 返回工资标准实体类
     */
    @GetMapping("/getWagesscaleByWid")
    @ResponseBody
    public Wagesscale getWagesscaleByWid(String wid) {
        return wagesscaleService.getWagesscaleByWid(wid);
    }

    /**
     * 修改工资标准
     */
    @PostMapping("/modifyWagesscale")
    @ResponseBody
    public Object modifyWagesscale(Wagesscale wagesscale){
        ResponseObject re=new ResponseObject();
        try {
            if (wagesscale!=null){
                wagesscale.setCreatetime(new Date());
                int stu=wagesscaleService.modifyWagesscale(wagesscale);
                if (stu!=0){
                    re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_CG);
                    re.setMessage("修改成功");
                }else{
                    re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_SB);
                    re.setMessage("修改失败");
                }
            }else {
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

    @DeleteMapping("/deleteWagesscale")
    @ResponseBody
    public Object deleteWagesscale(String wid){
        ResponseObject re=new ResponseObject();
        try {
            int stu=wagesscaleService.deleteWagesscale(wid);
            if (stu!=0){
                re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_CG);
                re.setMessage("删除成功");
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

    /**
     * 接收添加岗位工资标准请求
     * @param jobscale
     * @return
     */
    @PostMapping("/addJobscale")
    @ResponseBody
    public Object addJobscale(Jobscale jobscale){
        ResponseObject re=new ResponseObject();
        try {
            if (jobscale!=null){
                jobscale.setJid(UuidTools.generateShortUuid());
                jobscale.setCreatetime(new Date());
                int stu = jobscaleService.insertJobscale(jobscale);
                if (stu!=0){
                    re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_CG);
                    re.setMessage("录入成功");
                }else {
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
     * 接收查询岗位工资标准请求
     */
    @GetMapping("/getNewJobscale")
    @ResponseBody
    public Object getNewJobscale(){
        ResponseObject reo=new ResponseObject();
        Jobscale jobscale=jobscaleService.queryJobscale();
        if (jobscale!=null){
            Date time=jobscale.getCreatetime();
            String re=DateTools.getDate(time);

            reo.setCode(ResponseCode.RESPONSE_STUDENT_CODE_CG);
            reo.setMessage("查询成功");
            reo.setData(jobscale);
        }else {
            reo.setCode(ResponseCode.RESPONSE_STUDENT_CODE_SB);
            reo.setMessage("查询失败");
        }
        return reo;
    }

    /**
     * 删除指定id岗位工资标准
     */
    @DeleteMapping("/deleteJobscale")
    @ResponseBody
    public Object deleteJobscale(String jid){
        ResponseObject re=new ResponseObject();
        try {
            int stu=jobscaleService.deleteJobscale(jid);
            if (stu!=0){
                re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_CG);
                re.setMessage("删除成功");
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

    /**
     * 接收根据id查询岗位工资标准请求
     * @param jid
     * @return
     */
    @GetMapping("/getJobscaleByWid")
    @ResponseBody
    public Jobscale getJobscaleByWid(String jid){
        return jobscaleService.getJobscaleByWid(jid);
    }
    /**
     * 接收修改岗位工资标准请求
     */
    @PostMapping("/updateJobscale")
    @ResponseBody
    public Object updateJobscale(Jobscale jobscale){
        ResponseObject re=new ResponseObject();
        try {
            if (jobscale!=null){
                jobscale.setCreatetime(new Date());
                int stu=jobscaleService.updateJobscale(jobscale);
                if (stu!=0){
                    re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_CG);
                    re.setMessage("修改成功");
                }else{
                    re.setCode(ResponseCode.RESPONSE_STUDENT_CODE_SB);
                    re.setMessage("修改失败");
                }
            }else {
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
}
