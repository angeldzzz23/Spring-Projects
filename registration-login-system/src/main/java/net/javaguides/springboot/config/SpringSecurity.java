package net.javaguides.springboot.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    // configure SecurityFilterChain
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((authorize) -> {
//                    authorize.anyRequest().authenticated();
//                    authorize.
                    authorize.requestMatchers("/register/**").permitAll();
                    authorize.requestMatchers("/index").permitAll();
                    authorize.requestMatchers("/users").hasRole ("ADMIN");

                })
                            .formLogin(
                                    form -> form
                                            .loginPage("/login")
                                            .loginProcessingUrl("/login")
                                            .defaultSuccessUrl("/users")
                                            .permitAll()
                            ).logout(
                                    logout -> logout
                                            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                            .permitAll()
                );
        return http.build();
    }
}
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//        http.csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests((authorize) -> {
//                    authorize.anyRequest().authenticated().formLogin(
//                            form -> form
//                                    .loginPage ("/login")
//                                    .loginProcessingUrl("/login")
//                                    .defaultSuccessUrl("/users")
//                                    .permitAll()
//                    );
//
//                });
//
//        return http.build();
//    }


