package com.github.tyang513.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;

/**
 * @author tao.yang
 * @date 2019-12-26
 */
public class SecurityAuthorizationFilter implements Filter {

    private static Logger logger = LoggerFactory.getLogger(SecurityAuthorizationFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Principal principal = request.getUserPrincipal();
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(24 * 60 * 60);
        String userName = (String) session.getAttribute("user");

        // CAS登录信息获取
        if (userName == null && principal != null) {
            logger.info("CAS 登录授权 {}", principal);
            userName = principal.getName();
            logger.info("cas user name is : {} ", userName);
            session.setAttribute("user", userName);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
