package com.zw.calculation.service;

import com.zw.calculation.mapper.PayslipMapper;
import com.zw.domain.Payslip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("payslipService")
public class PayslipServiceImpl implements PayslipService {
    @Autowired
    private PayslipMapper payslipMapper;

    /**
     * 添加员工工资条
     * @param payslip
     * @return
     */
    @Override
    public int insertPayslip(Payslip[] payslip) {
        return payslipMapper.insertPayslip(payslip);
    }

    /**
     * 根据工号查询工资单信息
     * @param ids
     * @return
     */
    @Override
    public Payslip[] queryPayslips(String[] ids) {
        return payslipMapper.queryPayslips(ids);
    }

    @Override
    public int deletePayslip(String[] ids) {
        return payslipMapper.deletePayslipsByEid(ids);
    }

    /**
     * 删除表中所有记录
     * @return
     */
    @Override
    public int deleteAll() {
        return payslipMapper.deleteAll();
    }


}
