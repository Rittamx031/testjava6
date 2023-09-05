package thatdz.test3.test3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SpringSecurityConfig {
  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  UserDetailsService userDetailsService(PasswordEncoder encoder) {
    UserDetails admin = User.withUsername("thatdz")
        .password(encoder.encode("thatdz")).roles("ADMIN").build();
    return new InMemoryUserDetailsManager(admin);
  }

  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
    // .authorizeHttpRequests((authorize) -> {
    //   authorize.requestMatchers("").authenticated();
    // })
    .authorizeHttpRequests((authorize) -> {
      authorize.anyRequest().permitAll();
    }).csrf(AbstractHttpConfigurer::disable).httpBasic(Customizer.withDefaults());
    return http.build();
  }
}
