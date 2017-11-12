package com.by.z.test.c.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * JPA的配置类
 *
 * <hr />
 *
 * 一、{@link @EnableTransactionManagement 启用了jpa的事务管理}
 * 二、{@link @EnableJpaRepositories 启用了jpa资源库并指定了上面定义的接口资源库位置}
 * 三、{@link @EntityScan 指定了定义实体的位置}
 *
 * @author zwp
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories(basePackages = "com.by.z.test.**.repositorys")
@EntityScan(basePackages = "com.by.z.test.**.entity")
public class JpaConfiguration {

    @Bean
    PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

}
