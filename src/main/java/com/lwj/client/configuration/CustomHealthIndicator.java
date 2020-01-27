package com.lwj.client.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.stereotype.Component;

import com.lwj.client.service.DbHealthService;

/**
 * eureka是通过心跳来保证客户端是否存活的，在摩西情况下，比如mongodb出现了异常，此时服务进程还是存在的，而且并不会在注册中心上被剔除
 * 此时通过健康检查可以解决此问题
 * 访问http://127.0.0.1:8005/actuator/health 会返回相应的信息
 * @author linwenjie
 *
 */
@Component
public class CustomHealthIndicator extends AbstractHealthIndicator {

	public static boolean isHealth = true;
	
	@Autowired
	private DbHealthService dbHealthService;
	
	@Override
	protected void doHealthCheck(Builder builder) throws Exception {
		System.out.println("health check...");
		//此处的代码的逻辑应该是调用数据库服务或者缓存以及其他服务，当出现异常信息时将相应的状态置为false
		//isHealth 的操作也应该与自动检查的分开，并且检查到mongo以及其他数据库或者缓存服务不可用的时候直接设置isHealth为false
		if(!dbHealthService.dbCheck()) {
			isHealth = false;
		}
		if(isHealth) {
			builder.up().withDetail("status", true);
		}else {
			builder.down().withDetail("status", false);
		}
		
		
	}

}
