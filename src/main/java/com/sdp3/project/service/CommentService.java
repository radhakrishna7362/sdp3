package com.sdp3.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp3.project.models.Comment;
import com.sdp3.project.repository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	public List<Comment> getCommentsByHouseId(long houseId) {
		return (List<Comment>) commentRepository.findByHouseId(houseId);
	}
	
	public void addComment(Comment comment) {
		commentRepository.save(comment);
	}
	
	public Comment getComment(long id) {
		return commentRepository.findById(id).get();
	}
	
	public void updateComment(Comment comment) {
		commentRepository.save(comment);
	}
}
