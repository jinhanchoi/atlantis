package com.jackcomeback.jinhan.config.security

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
@Configuration
@EnableWebSecurity
@EnableGlobalAuthentication
class SpringSecurityConfiguration() : WebSecurityConfigurerAdapter(){

    override fun configure(web: WebSecurity){
        web.ignoring()
                .antMatchers("/User")
    }
    override fun configure(http: HttpSecurity){
        http.authorizeRequests()
                .antMatchers("/User/*").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin().permitAll()
    }
}