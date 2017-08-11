package com.springboot.app.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.springboot.app.assignment.bean.ResouceBean;
import com.springboot.app.assignment.service.RestaurantService;
import com.springboot.app.assignment.util.AppConstants;

/**
 * 
 * @author puneet.negi
 *
 */
@SpringBootApplication
public class AssignmentApplication implements CommandLineRunner {

	@Autowired
	ResouceBean resourceBean;

	@Autowired
	RestaurantService restaurantService;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(AssignmentApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

	/**
	 * This method populate  the File URL from command line , If command
	 * line is not available the it will read default file URL from resource
	 * properties file.
	 */
	@Override
	public void run(String... args) throws Exception {

		System.out.println("Spring Boot Application is running..");

		if (AppConstants.EMPTY_STRING.equals(resourceBean.getFileUrl()) || resourceBean.getFileUrl() == null) {
			resourceBean.setFileUrl(args[0].toString());
		}

		restaurantService.getBestDish(resourceBean.getFileUrl());

	}
}
