package com.wyf.hello.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class CollectionUtils {

    private static  final Logger logger = LoggerFactory.getLogger(CollectionUtils.class);

    /**
     * 创建指定大小的map
     * @param size
     * @return
     */
    public static HashMap createSizeMap(int size){
        return  com.google.common.collect.Maps.newHashMapWithExpectedSize(size);
    }

}
