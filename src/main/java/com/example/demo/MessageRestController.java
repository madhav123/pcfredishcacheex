package com.example.demo;

import java.util.Date;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConfigurationProperties
public class MessageRestController {
	
	@Autowired
	private RedisTemplate redisTemplate;

		@Value("${hyd}") 	
		 String locaiton;
		@RequestMapping("/hello")
		String getMessage(@RequestParam(value = "name") String name) {
			String rsp = "Hi " + name + " : responded on - " + new Date();
			System.out.println(rsp);
			return rsp;
		}
		
		@RequestMapping("/getlocation")
		String getMessage() {
			
			return locaiton;
		}
		
		@RequestMapping("/putdatatocache")
		String putcache() {
			redisTemplate.opsForValue().set("student", "madhav");
			
			
			return "Madhav" + redisTemplate.getClientList();
		}
		
		@RequestMapping("/getcachedata")
		String getMessage1() {
		
		
			return "Madhav-test" +redisTemplate.opsForValue().get("student");
		}
}
