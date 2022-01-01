package com.sdp3.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COMMENT")
public class Comment {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column(name="HOUSE_ID")
	private long houseId;
	
	@Column(name="USER_ID")
	private long userId;
	
	@Column(name="COMMENT_MESSAGE")
	private String commentMsg;
	
	@Column(name="IMAGE")
	private String image;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public long getHouseId() {
		return houseId;
	}

	public void setHouseId(long houseId) {
		this.houseId = houseId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getCommentMsg() {
		return commentMsg;
	}

	public void setCommentMsg(String commentMsg) {
		this.commentMsg = commentMsg;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Comment [Id=" + Id + ", houseId=" + houseId + ", userId=" + userId + ", commentMsg=" + commentMsg
				+ ", image=" + image + "]";
	}
	
}
