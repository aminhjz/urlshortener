package com.aminhjz.interview.urlshortener.configuration;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class ZookeeperConfig {

    @Bean
    public CuratorFramework createCuratorZookeeperClient(Environment environment){
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(environment.getProperty("app.zookeeper.host", "localhost:2181"), new RetryNTimes(10, 200));
        curatorFramework.start();
        return curatorFramework;
    }
}
