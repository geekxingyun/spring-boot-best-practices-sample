package com.xingyun.springbootwithlogback.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.ConfigurablePropertyResolver;
import org.springframework.core.env.PropertyResolver;
import org.springframework.stereotype.Component;

/**
 * @author qing-feng.zhao
 */
@Component
public class StaticPropertiesUtils extends PropertySourcesPlaceholderConfigurer {

    private static PropertyResolver propertyResolver;

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess,
                                     ConfigurablePropertyResolver propertyResolver) throws BeansException {
        super.processProperties(beanFactoryToProcess, propertyResolver);
        StaticPropertiesUtils.propertyResolver = propertyResolver;
    }

    public static String getProperty(String key){
        return propertyResolver.getProperty(key);
    }
}
