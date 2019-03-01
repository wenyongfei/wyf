package com.wyf.hello.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(-1)
@Component
public class DynamicDataSourceAspect {
    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);
    @Before("execution(* com.wyf.*.service..*.*(..))&& @annotation(ds)")
    public void switchDataSource(JoinPoint point,TargetDataSource ds) {
        DataSourceType dsType = ds.name();
        if (!DynamicDataSourceHolder.containDataSource(dsType)) {
        } else {
            DynamicDataSourceHolder.setDataSouce(dsType);
        }
    }

    @After("execution(* com.wyf.*.service..*.*(..))")
    public void cleanDataSource(JoinPoint point) {
        DynamicDataSourceHolder.clearDataSourceType();
    }

}
