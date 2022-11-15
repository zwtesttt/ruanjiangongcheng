package com.zw.calculation.service;

import com.zw.domain.Payslip;

import java.util.List;

public interface PayslipService {
    int insertPayslip(Payslip[] payslip);

    Payslip[] queryPayslips(String[] ids);

    int deletePayslip(String[] ids);

    int deleteAll();
}
