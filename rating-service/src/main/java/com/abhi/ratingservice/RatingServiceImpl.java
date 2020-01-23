package com.abhi.ratingservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingServiceRepo ratingRepo;

	@Override
	public Ratings getRatingForProduct(Integer productId) {
		return ratingRepo.findByProductId(productId);
	}

}
