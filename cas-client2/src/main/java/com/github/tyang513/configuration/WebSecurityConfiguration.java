package com.github.tyang513.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @author tao.yang
 * @date 2019-01-28
 */
@Configuration
//@EnableWebSecurity
public class WebSecurityConfiguration /*extends WebSecurityConfigurerAdapter*/ {

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(WebSecurityConfiguration.class);

//    @Autowired
//    private ApplicationConfiguration configuration;
//
//    /**
//     *
//     * @return ServiceProperties
//     */
//    @Bean
//    public ServiceProperties createServiceProperties() {
//        ServiceProperties serviceProperties = new ServiceProperties();
//        serviceProperties.setService(configuration.getSecurity());
//        serviceProperties.setSendRenew(false);
//        return serviceProperties;
//    }
//
//    /**
//     *
//     * @return CasAuthenticationFilter
//     * @throws Exception
//     */
//    @Bean
//    public CasAuthenticationFilter casAuthenticationFilter() throws Exception {
//        CasAuthenticationFilter casAuthenticationFilter = new CasAuthenticationFilter();
//        casAuthenticationFilter.setAuthenticationManager(authenticationManager());
//        return casAuthenticationFilter;
//    }
//
//    /**
//     * 配置CAS登录页面
//     * @return CasAuthenticationEntryPoint
//     */
//    @Bean
//    public CasAuthenticationEntryPoint casAuthenticationEntryPoint() {
//        CasAuthenticationEntryPoint casAuthenticationEntryPoint = new CasAuthenticationEntryPoint();
//        casAuthenticationEntryPoint.setLoginUrl(configuration.getCasServerLoginUrl());
//        // 这里可以直接上面的 createServiceProperties
//        casAuthenticationEntryPoint.setServiceProperties(createServiceProperties());
//        return casAuthenticationEntryPoint;
//    }
//
//    /**
//     *
//     * @return CasAuthenticationProvider
//     */
//    @Bean
//    public CasAuthenticationProvider casAuthenticationProvider() {
//        CasAuthenticationProvider casAuthenticationProvider = new CasAuthenticationProvider();
//        casAuthenticationProvider.setAuthenticationUserDetailsService(customUserDetailsService());
//        casAuthenticationProvider.setServiceProperties(createServiceProperties());
//        casAuthenticationProvider.setTicketValidator(cas20ServiceTicketValidator());
//        casAuthenticationProvider.setKey("an_id_for_this_auth_provider_only");
//        return casAuthenticationProvider;
//    }
//
//    /**
//     *
//     * @return Cas20ServiceTicketValidator
//     */
//    @Bean
//    public Cas20ServiceTicketValidator cas20ServiceTicketValidator() {
//        return new Cas20ServiceTicketValidator(configuration.getCasServerUrlPrefix());
//    }
//
//    /**
//     * @return AuthenticationUserDetailsService<CasAssertionAuthenticationToken>
//     */
//    @Bean
//    public AuthenticationUserDetailsService<CasAssertionAuthenticationToken> customUserDetailsService() {
//        return new CustomUserDetailsService();
//    }


}
