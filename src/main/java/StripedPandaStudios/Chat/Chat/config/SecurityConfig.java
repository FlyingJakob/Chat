package StripedPandaStudios.Chat.Chat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@PropertySource("classpath:application.properties")
public class SecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeRequests((authorize) -> authorize
                .requestMatchers("/").authenticated()
        );

        http.authenticationManager(customAuthenticationManager(http));

        http.oauth2Login()
                .defaultSuccessUrl("/google-success")
                .permitAll();

        http.formLogin()
                .loginPage("/signin")
                .loginProcessingUrl("/signin")
                .defaultSuccessUrl("/", true)
                .failureUrl("/signin?error=true");

        return http.build();
    }

    @Bean
    public AuthenticationManager customAuthenticationManager(HttpSecurity http) throws Exception {

        var authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);

        return authenticationManagerBuilder.build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
