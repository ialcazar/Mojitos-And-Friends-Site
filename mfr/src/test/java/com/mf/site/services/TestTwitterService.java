package com.mf.site.services;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.fail;

import org.junit.Test;

import twitter4j.TwitterException;
import twitter4j.User;

import com.mf.site.exceptions.ServiceException;
import com.mf.site.services.impl.TwitterServiceT4j;

public class TestTwitterService {
	

	@Test
	public void authenticate_correct() throws TwitterException {
		//ARRANGE
		String expectedAuthenticationUrl = "http://api.twitter.com/oauth/authenticate?oauth_token=null";
		
		TwitterProvider 	twitterProvider 	= mock(TwitterProvider.class);
		when(twitterProvider.authenticationURL()).thenReturn(expectedAuthenticationUrl);
		
		//ACT

		TwitterServiceT4j twitterService = new TwitterServiceT4j(twitterProvider);
		String authenticationUrl = twitterService.authenticate();
		
		//ASSERTS
		verify(twitterProvider).authenticationURL();
		assertThat(authenticationUrl,equalTo(expectedAuthenticationUrl));
		

	}
	
	@Test
	public void authenticate_with_error() throws TwitterException {
		//ARRANGE
		
		TwitterProvider 	twitterProvider 	= mock(TwitterProvider.class);
		when(twitterProvider.authenticationURL()).thenThrow(new ServiceException("Authentication Failure"));
		
		//ACT

		TwitterServiceT4j twitterService = new TwitterServiceT4j(twitterProvider);
		try{
			twitterService.authenticate();
			fail();
		}catch(ServiceException e){
			assertThat(e.getMessage(),containsString("Authentication"));
		}
		
		//ASSERTS
		verify(twitterProvider).authenticationURL();
	}
	
	@Test
	public void verifyCredentials_correct(){
		//TODO next test
		fail();
//		TwitterServiceT4j twitterService = new TwitterServiceT4j(twitterProvider);
//		
//		MojitoUser = twitterService.verifyCredentials(oauth_verifier);

		
	}

}
