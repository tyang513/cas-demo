package com.github.tyang513.entity;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import java.util.function.Function;
//import java.util.stream.Collectors;

/**
 * @author tao.yang
 * @date 2019-01-28
 */
public class CustomUserDetails /*implements UserDetails*/ {

    private String username;

    private String password;

    private boolean accountNonExpired = true;

    private boolean accountNonLocked = true;

    private boolean credentialsNonExpired =true;

    private boolean enabled = true;

//    private Collection<? extends GrantedAuthority> authorities;
//
//    private List<String> roles;
//
//
//    public CustomUserDetails(String username, Collection<? extends GrantedAuthority> authorities){
//        super();
//        this.username = username;
//        this.password = "";
//        this.accountNonExpired = true;
//        this.accountNonLocked = true;
//        this.credentialsNonExpired = true;
//        this.enabled = true;
//        this.authorities = authorities;
//        this.roles = new ArrayList<>();
//        this.roles.addAll(authorities.stream().map((Function<GrantedAuthority, String>) GrantedAuthority::getAuthority).collect(Collectors.toList()));
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return accountNonExpired;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return accountNonLocked;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return credentialsNonExpired;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return enabled;
//    }
}
