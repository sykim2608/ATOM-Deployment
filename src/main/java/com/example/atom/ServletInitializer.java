package com.example.atom;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Servlet Initializer.
 * @author sykim@ntels.com
 */
public class ServletInitializer extends SpringBootServletInitializer {
	/**
	 * Spring Application Builder
	 * @param application
	 * @return application sources
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

}
