package com.sdp3.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdp3.project.models.Rating;

public interface RatingRepository extends JpaRepository<Rating,Long> {
	Iterable<Rating> findByHouseId(long houseId);
	Iterable<Rating> findByUserId(long userId);
}
