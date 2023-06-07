package net.javaguides.springboot.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    // configure SecurityFilterChain
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((authorize) -> {
                    authorize.anyRequest().authenticated();
                })
                            .formLogin(
                                    form -> form
                                            .loginPage("/login")
                                            .loginProcessingUrl("/login")
                                            .defaultSuccessUrl("/users")
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


