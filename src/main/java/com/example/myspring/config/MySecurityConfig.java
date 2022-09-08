//package com.example.myspring.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//
//@Configuration
//@EnableWebSecurity
//@ComponentScan(basePackages = "com.example.myspring")
//public class MySecurityConfig extends WebSecurityConfigurerAdapter{
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception{
////        http
////                .authorizeRequests()
////                .antMatchers("/api/**").authenticated()
////                .antMatchers("/home/**").permitAll()
////                .and()
////                .formLogin()
////                .and()
////                .httpBasic();
////
////    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
//        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//        UserDetails user1 = User.withUsername("gabriel").password("12345").authorities("admin").build();
//        UserDetails user2 = User.withUsername("user").password("12345").authorities("user").build();
//
//        userDetailsService.createUser(user1);
//        userDetailsService.createUser(user2);
//        auth.userDetailsService(userDetailsService);
//
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//
////    @Bean
////    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////        http
////                .authorizeRequests()
////                .antMatchers("/dashboard").authenticated()
////                .antMatchers("/home").permitAll()
////                .antMatchers().permitAll()
////                .and()
////                .formLogin()
////                .and()
////                .httpBasic();
////        return http.build();
////    }
////    @Bean
////    public WebSecurityCustomizer webSecurityCustomizer() throws Exception{
////        return null;
////    }
//
//}
