package com.zw.performance.service;

import com.zw.domain.Performance;
import com.zw.performance.mapper.PerformanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("performanceService")
public class PerformanceServiceImpl implements PerformanceService {

    @Autowired
    private PerformanceMapper performanceMapper;

    /**
     * 添加员工具体表现
     * @param performance
     * @return
     */
    @Override
    public int insertPerformance(Performance performance) {
        return performanceMapper.insertPerformance(performance);
    }

    /**
     * 查询员工具体表现情况
     * @param eid
     * @return
     */
    @Override
    public Performance selectPerformanceById(String eid) {
        return performanceMapper.selectPerformanceById(eid);
    }

    /**
     * 删除员工所有具体表现情况
     * @param eid 工号
     * @return
     */
    @Override
    public int deletePerformance(String eid) {
        return performanceMapper.deletePerformanceByEid(eid);
    }

    /**
     * 删除员工一条具体表现记录
     * @param pid
     * @return
     */
    @Override
    public int deletePerformanceByPid(String pid) {
        return performanceMapper.deletePerformanceByPid(pid);
    }

    /**
     * 修改员工具体表现情况
     * @param performance
     * @return
     */
    @Override
    public int updatePerformanceByPid(Performance performance) {
        return performanceMapper.updatePerformanceByPid(performance);
    }

    /**
     * 根据pid查询具体表现情况记录
     * @param pid
     * @return
     */
    @Override
    public Performance selectPerformanceByPid(String pid) {
        return performanceMapper.selectPerformanceByPid(pid);
    }
}
