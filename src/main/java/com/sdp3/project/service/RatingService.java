package com.sdp3.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp3.project.models.Rating;
import com.sdp3.project.repository.RatingRepository;

@Service
public class RatingService {

	@Autowired
	RatingRepository ratingRepository;
	
	public void addRating(Rating rating) {
		ratingRepository.save(rating);
	}
	
	public List<Rating> getRatingByHouseId(long houseId){
		return (List<Rating>) ratingRepository.findByHouseId(houseId);
	}
}
