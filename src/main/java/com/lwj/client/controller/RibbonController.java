package com.lwj.client.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ribbonTest")
public class RibbonController {

	/**
	 * 测试重试
	 * @return
	 */
	@GetMapping("/testRetry")
	public String testRetry() {
		System.out.println("client 2 retry...");
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("client 2 retry2...");
		return "client2";
	}
	
}
