package com.mf.site.model;

import twitter4j.User;
import twitter4j.auth.RequestToken;

public class MojitoUser {

	private String twitterId;
	private String name;
	private String screenName;
	private String profileImg;

	public MojitoUser(String twitterId, String name, String screenName, String profileImg) {
		this.twitterId = twitterId;
		this.name = name;
		this.screenName = screenName;
		this.profileImg = profileImg;
	}

	public void setRequestToken(RequestToken requestToken) {
		// TODO Auto-generated method stub
		
	}

	public String getTwitterId() {
		
		return this.twitterId;
	}


}
