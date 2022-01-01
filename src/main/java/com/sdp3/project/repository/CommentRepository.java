package com.sdp3.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdp3.project.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	Iterable<Comment> findByHouseId(long houseId);
	
}
