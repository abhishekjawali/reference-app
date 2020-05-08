package com.abhi.compositeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompositeController {

	@Autowired
	private CompositeService compositeService;

	@GetMapping(path = "/product/{productId}")
	public ResponseEntity<CompositeProduct> getProductDetails(@PathVariable Integer productId) {
		CompositeProduct product = compositeService.getProductById(productId);
		return new ResponseEntity<CompositeProduct>(product, HttpStatus.OK);
	}
	
	@GetMapping(path = "/healthz")
	public ResponseEntity<String> healthz() {

		return new ResponseEntity<String>("App is running!", HttpStatus.OK);
	}
}
