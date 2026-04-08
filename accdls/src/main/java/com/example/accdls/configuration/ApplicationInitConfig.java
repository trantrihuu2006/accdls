package com.example.accdls.configuration;

import com.example.accdls.entity.User;
import com.example.accdls.enums.Roles;
import com.example.accdls.respository.UserRespository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ApplicationInitConfig {

    PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner(UserRespository userRespository) {
        return args -> {
              if (userRespository.findByUsername("admin").isEmpty()) {
                  Set<String> roles = new HashSet<>();
                  roles.add(Roles.ADMIN.name());
                  User user = User.builder()
                          .username("admin")
                          .password(passwordEncoder.encode("admin"))
                          .roles(roles)
                          .build();

                  userRespository.save(user);
                  log.warn("admin user has been created with defaults password: admin, please again");
              }
        };
    }
}
