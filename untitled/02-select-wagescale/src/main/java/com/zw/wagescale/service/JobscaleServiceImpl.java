package com.zw.wagescale.service;

import com.zw.domain.Jobscale;
import com.zw.wagescale.mapper.JobscaleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("jobscaleService")
public class JobscaleServiceImpl implements JobscaleService {
    @Autowired
    private JobscaleMapper jobscaleMapper;

    /**
     * 添加各岗位工资标准记录
     * @param jobscale
     * @return
     */
    @Override
    public int insertJobscale(Jobscale jobscale) {
        return jobscaleMapper.insertJobscale(jobscale);
    }

    /**
     * 查询一条最新的岗位工资标准记录
     * @return
     */
    @Override
    public Jobscale queryJobscale() {
        return jobscaleMapper.queryJobscale();
    }

    /**
     * 根据id删除岗位工资标准
     * @param jid
     * @return
     */
    @Override
    public int deleteJobscale(String jid) {
        return jobscaleMapper.deleteJobscale(jid);
    }

//    根据id查询岗位工资标准
    @Override
    public Jobscale getJobscaleByWid(String jid) {
        return jobscaleMapper.getJobscaleByWid(jid);
    }
//    修改岗位工资标准
    @Override
    public int updateJobscale(Jobscale jobscale) {
        return jobscaleMapper.updateJobscale(jobscale);
    }
}
