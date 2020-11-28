package com.spring.boot.rocks;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

import com.spring.boot.rocks.model.User;
import com.spring.boot.rocks.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class DemoApplication {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }

  @Bean
  CommandLineRunner start(UserRepository userRepository, PasswordEncoder passwordEncoder){
    return args -> {
      User user = new User("ajkr195", passwordEncoder.encode("12345678"));
      userRepository.save(user).subscribe();

      userRepository.findAll().log().subscribe(u -> log.info("user: {}", u));
    };
  }

}
