package com.zw.employee;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan(basePackages="com.zw.employee.mapper")
@EnableDiscoveryClient
@EnableFeignClients(basePackageClasses = com.zw.api.openfeign.PerformanceFeign.class)
public class EmployeeAppliction {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeAppliction.class,args);
    }
}