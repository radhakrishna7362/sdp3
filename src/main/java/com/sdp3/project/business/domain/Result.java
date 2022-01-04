package com.sdp3.project.business.domain;

public class Result {
	private boolean checkKeyEncrypted;
	private String MetaKey;
	public boolean isCheckKeyEncrypted() {
		return checkKeyEncrypted;
	}
	public void setCheckKeyEncrypted(boolean checkKeyEncrypted) {
		this.checkKeyEncrypted = checkKeyEncrypted;
	}
	public String getMetaKey() {
		return MetaKey;
	}
	public void setMetaKey(String metaKey) {
		MetaKey = metaKey;
	}
}
