package com.nexters.winemagic.user.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @GetMapping("/")
  public String test() {
    return "Hello World";
  }
}
