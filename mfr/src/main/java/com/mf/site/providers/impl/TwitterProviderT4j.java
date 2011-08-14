package com.mf.site.providers.impl;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

import com.mf.site.exceptions.TwitterProviderException;
import com.mf.site.model.MojitoUser;

import com.mf.site.providers.TwitterProvider;

public class TwitterProviderT4j implements TwitterProvider {
	private String returnUrl;
	private Twitter twitter4j;
	private RequestToken requestToken;
	
	
	public TwitterProviderT4j(Twitter twitter4j, String returnUrl) {
		this.twitter4j = twitter4j;
		this.returnUrl = returnUrl;
	}

	public String authenticationURL() throws TwitterProviderException{
		String consumerKey = "Mq8IGEgB2wGcNCA2Qh3KPw";
		String consumerSecret = "xFTscxX9WEkQNUtVaTm4ZaCm8xTkU7yBTK4UZCuss";
		try {
			
			twitter4j.setOAuthConsumer(consumerKey, consumerSecret);
	    
			requestToken = twitter4j.getOAuthRequestToken(returnUrl);
			
		} catch (TwitterException e) {
			throw new TwitterProviderException(e);
		}
		
	    return requestToken.getAuthenticationURL();

	}

	public MojitoUser verifyCredentials(String oauth_verifier) {
		User user = null;
		MojitoUser mojitoUser = null;
		AccessToken accessToken = null;
		try {
			accessToken = twitter4j.getOAuthAccessToken(this.requestToken, oauth_verifier);
			user = twitter4j.verifyCredentials();
			if(user != null)
				mojitoUser = new MojitoUser(user.getName(),user.getName(),user.getScreenName(),user.getProfileImageURL().toString());
		} catch (TwitterException e) {
			throw new TwitterProviderException(e);
		}
				
		
		return mojitoUser;
	}

}
