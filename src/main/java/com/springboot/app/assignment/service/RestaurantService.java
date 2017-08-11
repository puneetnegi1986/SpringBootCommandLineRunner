package com.springboot.app.assignment.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.app.assignment.bean.ResouceBean;
import com.springboot.app.assignment.util.AppConstants;

/**
 * @author puneet.negi
 *
 */
@Service
public class RestaurantService {

	@Autowired
	ResouceBean resourceBean;


	/**
	 * This Method return max value of food satisfaction for customers.
	 * @param fileUrl
	 */
	public void getBestDish(String fileUrl) {

		try (Stream<String> stream = Files.lines(Paths.get(fileUrl))) {

			Optional<Integer> maxValue = stream
					.map(data -> Integer.parseInt(data.split(AppConstants.EMPTY_STRING)[0])
							/ Integer.parseInt(data.split(AppConstants.EMPTY_STRING)[1]))
					.max(Comparator.naturalOrder());
			System.out.println(maxValue.get());
		} catch (IOException e) {
			System.out.println();
		}
	}
}
