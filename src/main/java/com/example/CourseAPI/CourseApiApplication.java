package com.example.CourseAPI;

import com.example.CourseAPI.Model.Course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;


@SpringBootApplication
public class CourseApiApplication {


	public static void main(String[] args) {
		SpringApplication.run(CourseApiApplication.class, args);
	}

}
