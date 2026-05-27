package com.github.tyang513.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author tao.yang
 * @date 2019-01-28
 */
@Configuration
public class ApplicationConfiguration {

    @Value("cas.client.serverName")
    private String serverName;

    @Value("cas.client.casServerUrlPrefix")
    private String casServerUrlPrefix;

    @Value("cas.client.casServerLoginUrl")
    private String casServerLoginUrl;

    @Value("cas.client.casServerLogoutUrl")
    private String casServerLogoutUrl;

    @Value("cas.client.security")
    private String security;

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getCasServerUrlPrefix() {
        return casServerUrlPrefix;
    }

    public void setCasServerUrlPrefix(String casServerUrlPrefix) {
        this.casServerUrlPrefix = casServerUrlPrefix;
    }

    public String getCasServerLoginUrl() {
        return casServerLoginUrl;
    }

    public void setCasServerLoginUrl(String casServerLoginUrl) {
        this.casServerLoginUrl = casServerLoginUrl;
    }

    public String getCasServerLogoutUrl() {
        return casServerLogoutUrl;
    }

    public void setCasServerLogoutUrl(String casServerLogoutUrl) {
        this.casServerLogoutUrl = casServerLogoutUrl;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }
}
