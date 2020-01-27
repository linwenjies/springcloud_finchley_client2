package com.lwj.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwj.client.configuration.CustomHealthIndicator;

@RestController
@RequestMapping("/health")
public class HealthController {

	@GetMapping("/down")
	public String down() {
		CustomHealthIndicator.isHealth = false;
		return "down";
	}
	
	@GetMapping("/up")
	public String up() {
		CustomHealthIndicator.isHealth = true;
		return "up";
	}
	
}
