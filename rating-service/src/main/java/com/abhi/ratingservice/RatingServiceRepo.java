package com.abhi.ratingservice;

import org.springframework.data.repository.CrudRepository;

public interface RatingServiceRepo extends CrudRepository<Ratings, Integer>{

	Ratings findByProductId(Integer productId);
}
