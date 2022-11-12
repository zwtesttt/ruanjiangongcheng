package com.zw.api.openfeign;

import com.zw.domain.Performance;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("03-performance")
public interface PerformanceFeign {

    /**
     * 根据工号删除员工具体表现情况的远程接口
     * @param eid
     * @return
     */
    @PostMapping("/deletePerformance")
    @ResponseBody
    Object deletePerformance(@RequestParam String eid);

    /**
     * 根据工号查询员工具体表现情况
     * @param eid
     * @return
     */
    @GetMapping("/selectPerformance")
    @ResponseBody
    Performance selectPerformance(@RequestParam String eid);
}
