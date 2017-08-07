package com.lj.spring.util;/**
 * @Author 段连洁 [ manajay.dlj@gmail.com ]
 * @Date 07/08/2017 2:51 PM
 */

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Properties;

/**
 * @author 段连洁 [manajay.dlj@gmail.com]
 * @class LJObjectFactory
 * @description custom mybatis objectFactory
 * @date 07/08/2017 2:51 PM
 */
public class LJObjectFactory extends DefaultObjectFactory {

    Logger logger = Logger.getLogger(LJObjectFactory.class);

    @Override
    public void setProperties(Properties properties) {
        logger.info("定制自己的属性: " + properties);
        super.setProperties(properties);
    }

    @Override
    public <T> T create(Class<T> type) {
        logger.info("使用定制对象工厂的create方法构建 单个对象");
        return super.create(type);
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        logger.info("使用定制对象工厂的create方法构建 列表对象");
        return super.create(type, constructorArgTypes, constructorArgs);
    }

    @Override
    public <T> boolean isCollection(Class<T> type) {
        return super.isCollection(type);
    }
}
