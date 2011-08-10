package com.mf.site.services.impl;

import com.mf.site.exceptions.ServiceException;

import com.mf.site.services.ConsumerProvider;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.auth.RequestToken;

public class TwitterServiceT4j {
	private Twitter twitter;
	private ConsumerProvider consumerProvider;

	public TwitterServiceT4j(ConsumerProvider consumerProvider, Twitter twitter) {
		this.twitter = twitter;
		this.consumerProvider = consumerProvider;
	}

	public String authenticate() {
		 	RequestToken requestToken = null;
			String url = null;
			String consumerKey = consumerProvider.key();
			String consumerSecret = consumerProvider.secret();
			
			try {
				twitter.setOAuthConsumer(consumerKey, consumerSecret);
				requestToken = twitter.getOAuthRequestToken();
				
				url = requestToken.getAuthenticationURL();
			} catch (TwitterException e) {
				throw new ServiceException(e);
			}
			
			return url;
		
	}

}
