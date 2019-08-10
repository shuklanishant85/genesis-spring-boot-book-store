package com.genesis.store.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@Value("${spring.application.name}")
	String applicationName;

	@GetMapping("/")
	public String getHomePage(Model model) {
		model.addAttribute("applicationName", applicationName);
		return "HomePage";
	}
}
