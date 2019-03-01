package com.wyf.hello.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class DynamicDataSourceHolder {

    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceHolder.class);

    public static List<DataSourceType> DATASOURCES = new ArrayList<>();

    private static final ThreadLocal<DataSourceType> SOURCE_HOLDER =  new  ThreadLocal();

    public static void setDataSouce(DataSourceType type){
        SOURCE_HOLDER.set(type);
    }

    public static String getDataSourceType() {
        DataSourceType type = SOURCE_HOLDER.get();
        //这里一般设置系统随机的一个主库
        if (type == null){
            return  DataSourceType.WYF_MASTER.name();
        }
        return SOURCE_HOLDER.get().name();
    }

    public static void clearDataSourceType() {
        SOURCE_HOLDER.remove();
    }


    public static boolean containDataSource(DataSourceType type) {
        return DATASOURCES.contains(type);
    }
}
