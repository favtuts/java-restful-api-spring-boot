package com.bts.imageclient.SpringApiTutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringApiTutorialApplication extends SpringBootServletInitializer {

	// public static void main(String[] args) {
	// 	SpringApplication.run(SpringApiTutorialApplication.class, args);
	// }

	public static void main(String[] args) {
		new SpringApiTutorialApplication().configure(new SpringApplicationBuilder(SpringApiTutorialApplication.class)).run(args);
	}

}
