/*
 * ShowSeek - Runner
 */

package com.capstone.ShowSeek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ShowSeekApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ShowSeekApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ShowSeekApplication.class, args);
	}
}
