package com.yinhang.api;

import com.yinhang.api.config.CorsConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.apache.commons.lang3.StringUtils;

@SpringBootApplication
@MapperScan("com.yinhang.api.mapper")
@EnableTransactionManagement
public class ApiApplication {
    @Autowired
    private CorsConfig corsConfig;

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    /**
     * 跨域过滤器
     *
     * @return
     */
    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.addAllowedOrigin("https://wechat.yisongbld.com");
        String origin = corsConfig.getOrigin();
        if (StringUtils.isNotEmpty(origin)) {
            String[] arr = origin.split(";");
            for (String it : arr) {
                corsConfiguration.addAllowedOrigin(it);
            }
        }
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        return corsConfiguration;
    }

}
