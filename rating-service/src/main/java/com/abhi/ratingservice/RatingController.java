package com.abhi.ratingservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingController {

	@Autowired
	private RatingService ratingService;

	@GetMapping(path = "/rating/product/{productId}")
	public ResponseEntity<Ratings> getRatingForProduct(@PathVariable Integer productId) {
		Ratings rating = ratingService.getRatingForProduct(productId);
		return new ResponseEntity<Ratings>(rating, HttpStatus.OK);
	}

	@GetMapping(path = "/healthz")
	public ResponseEntity<String> healthz() {

		return new ResponseEntity<String>("App is running!", HttpStatus.OK);
	}

}
