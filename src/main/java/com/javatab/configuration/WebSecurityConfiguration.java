package com.javatab.configuration;

import com.javatab.security.AuthenticationTokenFilter;
import com.javatab.security.EntryPointUnauthorizedHandler;
import com.javatab.security.TokenUtils;
import com.javatab.service.SecurityService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

  private final EntryPointUnauthorizedHandler unauthorizedHandler;
  private final UserDetailsService userDetailsService;
  private final SecurityService securityService;
  private final TokenUtils tokenUtils;
  private final AuthenticationConfiguration configuration;

  public WebSecurityConfiguration(EntryPointUnauthorizedHandler unauthorizedHandler, UserDetailsService userDetailsService, SecurityService securityService, TokenUtils tokenUtils, AuthenticationConfiguration configuration) {
    this.unauthorizedHandler = unauthorizedHandler;
    this.userDetailsService = userDetailsService;
    this.securityService = securityService;
    this.tokenUtils = tokenUtils;
    this.configuration = configuration;
  }

  @Override
  public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
    authenticationManagerBuilder
      .userDetailsService(this.userDetailsService)
      .passwordEncoder(this.passwordEncoder());
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(10);
  }

  @Bean
  public AuthenticationManager authenticationManage() throws Exception {
    return configuration.getAuthenticationManager();
  }

  @Bean
  public AuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
    AuthenticationTokenFilter authenticationTokenFilter = new AuthenticationTokenFilter(tokenUtils, userDetailsService);
    authenticationTokenFilter.setAuthenticationManager(authenticationManage());
    return authenticationTokenFilter;
  }

  @Bean
  public SecurityService securityService() {
    return this.securityService;
  }

  protected void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
      .csrf()
        .disable()
      .exceptionHandling()
        .authenticationEntryPoint(this.unauthorizedHandler)
        .and()
      .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
      .authorizeRequests()
        .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
        .antMatchers("/auth/**",
                "/h2-console/**",
                "/api-docs/**",
                "/swagger-ui.html",
                "/swagger-ui/**").permitAll()
        .anyRequest().authenticated()
         .and()
      .cors();

    // To fix h2-console - https://stackoverflow.com/questions/53395200/h2-console-is-not-showing-in-browser
    httpSecurity.headers().frameOptions().disable();

    // Custom JWT based authentication
    httpSecurity
      .addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
  }

}
