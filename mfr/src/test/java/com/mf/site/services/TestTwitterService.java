package com.mf.site.services;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.auth.RequestToken;

import com.mf.site.services.impl.TwitterServiceT4j;

public class TestTwitterService {


	@Test
	public void authenticate_result_ok() throws TwitterException {
		
		String consumerKey = "1234";
		String consumerSecret = "2345";
		String expectedAuthenticationUrl = "http://api.twitter.com/oauth/authenticate?oauth_token=null";

		Twitter 			twitter 			= mock(Twitter.class);
		ConsumerProvider 	consumerProvider 	= mock(ConsumerProvider.class);
		RequestToken 		requestToken		= new RequestToken(null,null); 			

		when(consumerProvider.key()).thenReturn(consumerKey);
		when(consumerProvider.secret()).thenReturn(consumerSecret);
		when(twitter.getOAuthRequestToken()).thenReturn(requestToken);

		TwitterServiceT4j twitterService = new TwitterServiceT4j(consumerProvider, twitter);

		String authenticationUrl = twitterService.authenticate();
		
		assertThat(authenticationUrl,equalTo(expectedAuthenticationUrl));

		verify(consumerProvider).key();
		verify(consumerProvider).secret();
		verify(twitter).setOAuthConsumer(consumerKey, consumerSecret);
		verify(twitter).getOAuthRequestToken();

	}

}
