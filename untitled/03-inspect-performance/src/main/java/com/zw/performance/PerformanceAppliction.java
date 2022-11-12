package com.zw.performance;

import com.zw.api.openfeign.EmployeeFeign;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@SpringBootApplication
@MapperScan(basePackages="com.zw.performance.mapper")
@EnableDiscoveryClient
@EnableFeignClients(basePackageClasses = EmployeeFeign.class)
public class PerformanceAppliction {
    public static void main(String[] args) {
        SpringApplication.run(PerformanceAppliction.class,args);
    }

//    @Bean
//    public CorsWebFilter corsWebFilter(){
//        CorsConfiguration configuration=new CorsConfiguration();
//        configuration.addAllowedMethod("*");
//        configuration.addAllowedHeader("*");
//        configuration.addAllowedOrigin("*");
//        UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**",configuration);
//        return new CorsWebFilter(source);
//    }
}