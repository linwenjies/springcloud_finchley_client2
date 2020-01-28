package com.lwj.client.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * basic认证
 * @author linwenjie
 *
 */
@RestController
@RequestMapping("/basicAuth")
public class BasicAuthController {

	@GetMapping("/testBasicAuth")
	public boolean testBasicAuth(@RequestHeader HttpHeaders headers) {
		System.out.println(headers.toString());
		return true;
	}
	
}
