package com.github.tyang513.context;

import org.jasig.cas.client.authentication.AuthenticationFilter;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.jasig.cas.client.util.HttpServletRequestWrapperFilter;
import org.jasig.cas.client.validation.Cas30ProxyReceivingTicketValidationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.HashMap;
import java.util.Map;

/**
 * 应用servlet context初始化
 *
 * @author tao.yang
 * @date 2018-05-24
 */
@Configuration
public class ApplicationServletContextInitializer implements ServletContextInitializer {

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(ApplicationServletContextInitializer.class);

    /**
     * 配置
     */
    @Autowired
    private ApplicationProperties properties;

    /**
     * @param servletContext
     * @throws ServletException
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        logger.info("初始化servlet context");
    }

    /**
     * Create CAS Authentication Filter
     *
     * @return FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean createCASAuthenticationFilter() {
        logger.info("初始化 CAS Authentication Filter");

        Map<String, String> filterParam = new HashMap<>(15);
        filterParam.put("casServerLoginUrl", properties.getCasServerLoginUrl());
        filterParam.put("serverName", properties.getServerName());

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setName("CAS Authentication Filter");
        registration.setFilter(new AuthenticationFilter());
        registration.setInitParameters(filterParam);
        registration.addUrlPatterns("/*");
        return registration;
    }

    /**
     * 用来验证ticket
     * Create CAS Validation Filter
     * @return FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean createCASValidationFilter(){
        logger.info("初始化 CAS Validation Filter");

        Map<String, String> filterParam = new HashMap<>(15);
        filterParam.put("casServerUrlPrefix", properties.getCasServerUrlPrefix());
        filterParam.put("serverName", properties.getServerName());
        filterParam.put("redirectAfterValidation", "true");
        filterParam.put("useSession", "true");

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setName("CAS Validation Filter");
        registration.setFilter(new Cas30ProxyReceivingTicketValidationFilter());
        registration.setInitParameters(filterParam);
        registration.addUrlPatterns("/*");

        return registration;
    }

    /**
     * Create CAS HttpServletRequest Wrapper Filter
     * @return
     */
    @Bean
    public FilterRegistrationBean getCreateCASHttpServletRequestWrapperFilter() {

        logger.info("初始化 CAS HttpServletRequest Wrapper Filter");

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setName("CAS HttpServletRequest Wrapper Filter");
        registration.setFilter(new HttpServletRequestWrapperFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }

    /**
     * Create CAS Single Sign Out Filter
     *
     * @return FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean createCASSingleSignOutFilter() {
        logger.info("初始化 CAS Single Sign Out Filter");

        Map<String, String> filterParam = new HashMap<>(15);
        filterParam.put("casServerUrlPrefix", properties.getCasServerUrlPrefix());

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setName("CAS Single Sign Out Filter");
        registration.setFilter(new SingleSignOutFilter());
        registration.setInitParameters(filterParam);
        registration.addUrlPatterns("/*");
        return registration;
    }

    /**
     * Create SingleSignOutHttpSessionListener
     *
     * @return ServletListenerRegistrationBean
     */
    @Bean
    public ServletListenerRegistrationBean createSingleSignOutHttpSessionListener() {
        logger.info("初始化 SingleSignOutHttpSessionListener");

        ServletListenerRegistrationBean registration = new ServletListenerRegistrationBean();
        registration.setListener(new SingleSignOutHttpSessionListener());
        return registration;
    }

    /**
     * 用来在登录成功后获取用户信息
     * Create CAS Validation Filter
     * @return FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean createSecurityAuthorizationFilter(){
        logger.info("初始化Security Authorization Filter");

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setName("Security Authorization Filter");
        registration.setFilter(new SecurityAuthorizationFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }

}

