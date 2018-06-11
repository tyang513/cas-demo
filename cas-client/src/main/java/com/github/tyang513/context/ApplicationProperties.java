package com.github.tyang513.context;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author tao.yang
 * @date 2018-05-24
 */
@Component
public class ApplicationProperties {

    @Value("${cas.client.serverName}")
    private String serverName;

    @Value("${cas.client.casServerUrlPrefix}")
    private String casServerUrlPrefix;

    @Value("${cas.client.casServerLoginUrl}")
    private String casServerLoginUrl;

    @Value("${cas.client.casServerLogoutUrl}")
    private String casServerLogoutUrl;

    @Value("${cas.client.security}")
    private String securityUrl;

    public String getCasServerUrlPrefix() {
        return casServerUrlPrefix;
    }

    public void setCasServerUrlPrefix(String casServerUrlPrefix) {
        this.casServerUrlPrefix = casServerUrlPrefix;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
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

    public String getSecurityUrl() {
        return securityUrl;
    }

    public void setSecurityUrl(String securityUrl) {
        this.securityUrl = securityUrl;
    }

}
