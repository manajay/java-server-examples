package com.manajay.cay.common.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * rsa 的配置文件, ConfigurationProperties必须要添加Component注解
 * @author manajay
 * @date 2017/12/16$
 */
@Component
@ConfigurationProperties(prefix = "rsa")
public class RsaConfiguration {

    /**
     * RSA加密的密钥
     */
    private String key;

    /**
     * RSA加密的值
     */
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
