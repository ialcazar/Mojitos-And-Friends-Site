package com.mf.site.services.impl;




import com.mf.site.services.TwitterProvider;



public class TwitterServiceT4j {
	private TwitterProvider  twitterProvider;
	

	public TwitterServiceT4j(TwitterProvider twitterProvider) {
		this.twitterProvider = twitterProvider;
		
	}

	public String authenticate() {
		
			
			String url = twitterProvider.authenticationURL();
			
			
			return url;
		
	}

}
