package com.zw.calculation;

import com.zw.api.openfeign.EmployeeFeign;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan(basePackages="com.zw.calculation.mapper")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.zw.api.openfeign")
public class PayslipAppliction {
    public static void main(String[] args) {
        SpringApplication.run(PayslipAppliction.class,args);
    }

}