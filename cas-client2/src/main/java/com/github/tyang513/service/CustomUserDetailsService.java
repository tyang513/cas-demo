package com.github.tyang513.service;

//import com.github.tyang513.entity.CustomUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.security.cas.authentication.CasAssertionAuthenticationToken;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.ArrayList;
//import java.util.List;

/**
 * @author tao.yang
 * @date 2019-01-28
 */
public class CustomUserDetailsService /*implements AuthenticationUserDetailsService<CasAssertionAuthenticationToken>*/ {

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

//    @Override
//    public UserDetails loadUserDetails(CasAssertionAuthenticationToken token) throws UsernameNotFoundException {
//        String login = token.getPrincipal().toString();
//        String username = login.toLowerCase();
//
//        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
//        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//
//        return new CustomUserDetails(username, grantedAuthorities);
//    }
}
