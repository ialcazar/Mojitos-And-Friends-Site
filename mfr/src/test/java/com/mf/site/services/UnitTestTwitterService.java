package com.mf.site.services;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.mf.site.exceptions.ServiceException;
import com.mf.site.exceptions.TwitterProviderException;
import com.mf.site.model.MojitoUser;
import com.mf.site.providers.TwitterProvider4j;
import com.mf.site.services.impl.TwitterServiceT4j;

public class UnitTestTwitterService {
	private TwitterProvider4j twitterProvider;
	private TwitterService twitterService;
	
	@Before
	public void setUp(){
		twitterProvider	= mock(TwitterProvider4j.class);
		twitterService  = new TwitterServiceT4j(twitterProvider);
	}

	@Test
	public void authenticate_correct()  {
		//ARRANGE
		String expectedAuthenticationUrl = "http://api.twitter.com/oauth/authenticate?oauth_token=null";
		
		
		when(twitterProvider.authenticationURL()).thenReturn(expectedAuthenticationUrl);
		
		//ACT

		
		String authenticationUrl = twitterService.authenticate();
		
		//ASSERTS
		verify(twitterProvider).authenticationURL();
		assertThat(authenticationUrl,equalTo(expectedAuthenticationUrl));
		

	}
	
	@Test
	public void authenticate_with_error() {
		//ARRANGE
		
		when(twitterProvider.authenticationURL()).thenThrow(new TwitterProviderException("Authentication Failure"));
		
		//ACT
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
	public void verify_credentials_correct(){
		String 		oauth_verifier = "1234";
		MojitoUser 	mojitoUserExpected = new MojitoUser("ialcazar","Israel","Israel Alcázar","/img/userProfile.jpg");
		
		when(twitterProvider.verifyCredentials(oauth_verifier)).thenReturn(mojitoUserExpected);
		
		//ACT
		MojitoUser mojitoUser = twitterService.verifyCredentials(oauth_verifier);
		
	
        assertNotNull(mojitoUser);
		verify(twitterProvider).verifyCredentials(oauth_verifier);

		
	}

}
