package com.github.tyang513.context;

import org.jasig.cas.client.authentication.AuthenticationFilter;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

        Map<String, String> filterParam = new HashMap<String, String>();
        filterParam.put("casServerLoginUrl", "http://localhost:8080/cas/login");
        filterParam.put("serverName", "http://localhost:8083/cas-client");

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setName("CAS Authentication Filter");
        registration.setFilter(new AuthenticationFilter());
        registration.setInitParameters(filterParam);
        registration.addUrlPatterns("/*");
        return registration;
    }


    /**
     * Cteate CAS Single Sign Out Filter
     *
     * @return FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean createCASSingleSignOutFilter() {
        logger.info("初始化 CAS Single Sign Out Filter");

        Map<String, String> filterParam = new HashMap<String, String>();
        filterParam.put("casServerUrlPrefix", "http://localhost:8080/cas");

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

}

