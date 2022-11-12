package com.zw.api.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient("02-wagesscale")
public interface WagesscaleFeign {

    /**
     * 查询最新的工资标准
     * @return
     */
    @GetMapping("/getWagesscale")
    @ResponseBody
    Object getWagesscale();

    /**
     * 查询各岗位工资第一级标准
     */
    @GetMapping("/getNewJobscale")
    @ResponseBody
    Object getNewJobscale();
}
