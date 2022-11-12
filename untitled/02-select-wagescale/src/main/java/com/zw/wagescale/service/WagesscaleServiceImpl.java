package com.zw.wagescale.service;

import com.zw.domain.Wagesscale;
import com.zw.wagescale.mapper.WagesscaleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("wagesscaleService")
public class WagesscaleServiceImpl implements WagesscaleService {
    @Autowired
    private WagesscaleMapper wagesscaleMapper;

    /**
     * 新建工资标准
     * @param wagesscale
     * @return
     */
    @Override
    public int addWagesscale(Wagesscale wagesscale) {
        return wagesscaleMapper.createWagesscale(wagesscale);
    }

    /**
     * 返回一条离当前时间最近的工资标准
     * @return
     */
    @Override
    public Wagesscale queryminTime() {
        return wagesscaleMapper.queryMinTime();
    }

    /**
     * 根据id查询工资标准
     * @param wid
     * @return
     */
    @Override
    public Wagesscale getWagesscaleByWid(String wid) {
        return wagesscaleMapper.getWagesscaleByWid(wid);
    }

    @Override
    public int modifyWagesscale(Wagesscale wagesscale) {
        return wagesscaleMapper.modifyWagesscale(wagesscale);
    }

    @Override
    public int deleteWagesscale(String wid) {
        return wagesscaleMapper.deleteWagesscale(wid);
    }
}
