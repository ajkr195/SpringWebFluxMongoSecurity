package com.spring.boot.rocks.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class DemoController {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @GetMapping("/")
  public String index(Model model, Principal principal) {
    String username = principal.getName();
    log.info("Authenticated user is: " + username);
    model.addAttribute("username", username);
    return "home";
  }

}
