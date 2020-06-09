package com.abhi.compositeservice;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompositeServiceImpl implements CompositeService {

	@Autowired
	RestTemplate restTemplate;

	@Value("${product.service.url}")
	private String productServiceUri;

	@Value("${rating.service.url}")
	private String ratingServiceUri;

	@Override
	public CompositeProduct getProductById(Integer productId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		Products product = restTemplate
				.exchange(productServiceUri + "/product/" + productId, HttpMethod.GET, entity, Products.class)
				.getBody();
		Ratings rating = null;

		try {
			rating = restTemplate
					.exchange(ratingServiceUri + "/rating/product/" + productId, HttpMethod.GET, entity, Ratings.class)
					.getBody();
		} catch (Exception e) {
			rating = null;
		}

		CompositeProduct compositeProduct = new CompositeProduct();
		compositeProduct.setProductId(productId);
		compositeProduct.setProductCompany(product.getProductCompany());
		compositeProduct.setProductCategory(product.getProductCategory());
		compositeProduct.setProductName(product.getProductName());
		compositeProduct.setProductDescription(product.getProductDescription());
		if (null != rating)
			compositeProduct.setRating(rating.getRating());
		return compositeProduct;
	}

}
