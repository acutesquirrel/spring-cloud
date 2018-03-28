package com.ewp.data;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.ewp.data.MyBatisRepository;

/**
* @ClassName: DataQuartzApplication
* @Description: TCC启动类，通过main方法启动
* @author zxj
* @date 2018年3月8日
*
*/
@EnableAsync
@EnableScheduling
@MapperScan(basePackages = "com.ewp.data.persistence", annotationClass = MyBatisRepository.class)
@SpringCloudApplication
public class DataQuartzApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataQuartzApplication.class, args);
    }
}
