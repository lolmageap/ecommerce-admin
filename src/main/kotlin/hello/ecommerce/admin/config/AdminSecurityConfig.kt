package hello.ecommerce.admin.config

import hello.ecommerce.admin.domain.user.service.AdminUserDetailService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder


//@Configuration
//@EnableWebSecurity
//class AdminSecurityConfig(val adminUserDetailService: AdminUserDetailService) {
//
//    @Throws(Exception::class)
//    protected fun configure(httpSecurity: HttpSecurity) {
//        httpSecurity
//                .csrf().disable()
//                .cors().disable()
//        httpSecurity
//                .authorizeRequests()
//                .antMatchers("/img/**", "/js/**", "/css/**", "/scss/**", "/vendor/**", "/**",
//                        "/users/sign-up", "/users/login", "/error", "/hello", "/users/register", "/login"
//                )
//                .permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/users/login")
//                .defaultSuccessUrl("/")
//                .usernameParameter("email")
//                .failureUrl("/users/login?error=true")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutSuccessUrl("/users/login")
//                .invalidateHttpSession(true)
//
//        httpSecurity.exceptionHandling().authenticationEntryPoint(SimpleAuthenticationEntryPoint())
//    }
//
//    @Bean
//    fun bPasswordEncoder(): PasswordEncoder {
//        return BCryptPasswordEncoder()
//    }
//
//    @Throws(Exception::class)
//    protected fun configure(auth: AuthenticationManagerBuilder) {
//        auth.userDetailsService<UserDetailsService?>(adminUserDetailService).passwordEncoder(bPasswordEncoder())
//    }
//
//}