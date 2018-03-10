package com.tydic.base.mvc;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.ResourceEntityResolver;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.web.context.support.AbstractRefreshableWebApplicationContext;

public class XmlWebApplicationContext extends AbstractRefreshableWebApplicationContext{

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException, IOException {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        beanDefinitionReader.setEnvironment(getEnvironment());
        beanDefinitionReader.setResourceLoader(this);
        beanDefinitionReader.setEntityResolver(new ResourceEntityResolver(this));

        loadBeanDefinitions(beanDefinitionReader);
    }
    
    protected void loadBeanDefinitions(XmlBeanDefinitionReader reader) throws IOException {
        String[] configLocations = getConfigLocations();
        if (configLocations != null) {
            ResourceLoader resourceLoader = reader.getResourceLoader();
            if (!(resourceLoader instanceof ResourcePatternResolver)) { 
                throw new IllegalStateException("资源加载器类型不对，预期[ResourcePatternResolver]实际[" + resourceLoader.getClass().getSimpleName() + "]");
            }
            Set<String> ingoreLocationSet = new HashSet<String>(configLocations.length);
            Set<String> addLocationSet = new HashSet<String>();
            Set<String> loadedConfigSet = new HashSet<String>(configLocations.length);
            for (String configLocation : configLocations) {
                if (ingoreLocationSet.contains(configLocation)) {
                    continue;
                }
                if (loadedConfigSet.contains(configLocation)) {
                    logger.info("配置文件[" + configLocation + "]已加载，忽略！");
                    continue;
                }
                reader.loadBeanDefinitions(configLocation);
                loadedConfigSet.add(configLocation);
            }
            for (String configLocation : addLocationSet) {
                if (loadedConfigSet.contains(configLocation)) {
                    logger.info("配置文件[" + configLocation + "]已加载，忽略！");
                    continue;
                }
                reader.loadBeanDefinitions(configLocation);
                loadedConfigSet.add(configLocation);
            }
        }
    }

}
