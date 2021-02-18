package com.nexters.winepick.config;

import com.nexters.winepick.interceptor.AuthenticationInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
public class WebMVConfig implements WebMvcConfigurer {

    private final AuthenticationInterceptor authenticationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.authenticationInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(new ArrayList<>(
                        Arrays.asList(
                                "/v2/api-docs",
                                "/v2/api/user/",
                                "/v2/api/survey/",
                                "/v2/api/result/",
                                "/v2/api/h2-console"
                        ))
                );
    }
}
