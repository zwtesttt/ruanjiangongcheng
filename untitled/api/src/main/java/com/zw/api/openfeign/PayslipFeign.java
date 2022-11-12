package com.zw.api.openfeign;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@EnableFeignClients("05-calculate-salaries")
public interface PayslipFeign {
    /**
     * 根据工号删除工资单
     * @param ids
     * @return
     */
    @DeleteMapping("/deletePayslip")
    @ResponseBody
    Object deletePayslip(@RequestBody String[] ids);
}
