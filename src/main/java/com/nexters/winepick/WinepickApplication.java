package com.nexters.winepick;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class WinepickApplication {

  public static void main(String[] args) {
    SpringApplication.run(WinepickApplication.class, args);
  }

}
