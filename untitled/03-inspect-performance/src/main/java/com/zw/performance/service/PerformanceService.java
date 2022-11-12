package com.zw.performance.service;

import com.zw.domain.Performance;

import java.util.List;

public interface PerformanceService {

    int insertPerformance(Performance performance);
    Performance selectPerformanceById(String eid);

    int deletePerformance(String eid);

    int deletePerformanceByPid(String pid);

    int updatePerformanceByPid(Performance performance);

    Performance selectPerformanceByPid(String pid);
}
