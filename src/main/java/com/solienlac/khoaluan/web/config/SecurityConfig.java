package com.solienlac.khoaluan.web.config;

import com.solienlac.khoaluan.web.domain.common.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    // Bean for login verification
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources/**",
                "/configuration/security", "/swagger-ui.html", "/webjars/**", "/api/solienlacdientu/v1/taikhoan/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .antMatcher("/api/**")
                .authorizeRequests().antMatchers("/api/solienlacdientu/v1/sinhvien/**").hasAnyAuthority("SINH_VIEN")
                .antMatchers("/api/solienlacdientu/v1/giangvien/**").hasAnyAuthority("GIANG_VIEN")
                .antMatchers("/api/solienlacdientu/v1/phuhuynh/**").hasAnyAuthority("PHU_HUYNH")
                .and()
                .authorizeRequests()
                .anyRequest().permitAll();

        http.addFilter(new AuthFilter(authenticationManager(), userDetailsService));
        // Not use session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

}