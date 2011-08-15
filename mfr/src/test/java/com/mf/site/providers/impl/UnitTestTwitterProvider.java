package com.mf.site.providers.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.never;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;


import com.mf.site.exceptions.TwitterProviderException;
import com.mf.site.model.MojitoUser;
import com.mf.site.providers.impl.TwitterProviderT4j;


public class UnitTestTwitterProvider {
	private final String consumerKey = "Mq8IGEgB2wGcNCA2Qh3KPw";
	private final String consumerSecret = "xFTscxX9WEkQNUtVaTm4ZaCm8xTkU7yBTK4UZCuss";
	private final String returnUrl = "http://localhost:8080/mfr/twitter/callback";
	private final String oauth_verifier ="1243";
	
	private TwitterProviderT4j twitterProvider;
	private Twitter twitter4j;
	private RequestToken requestToken;
	private AccessToken accessToken;
	
	@Before
	public void setUp(){
		accessToken = mock(AccessToken.class);
		requestToken = new RequestToken(null,null);
		twitter4j = mock(Twitter.class);
		twitterProvider = new TwitterProviderT4j(twitter4j,returnUrl);
	}
	
	
	@Test
	public void obtaining_an_authentication_url() throws TwitterException {
		
		when(twitter4j.getOAuthRequestToken(returnUrl)).thenReturn(requestToken);
		
		
		String urlExpected = twitterProvider.authenticationURL();
		
		assertNotNull(urlExpected);
		verifyTwitter4jRequestToken();
	
	}
	
	private void verifyTwitter4jRequestToken() throws TwitterException {
		verify(twitter4j).setOAuthConsumer(consumerKey,consumerSecret);
		verify(twitter4j).getOAuthRequestToken(returnUrl);
//		verify(requestToken).getAuthenticationURL();
		
	}


	@Test
	public void obtaining_an_authentication_url_throws_exception() throws TwitterException {
		when(twitter4j.getOAuthRequestToken(returnUrl)).thenThrow(new TwitterException("AuthenticationRelevant discussions can be on the Internet at"));
		
		try{
			twitterProvider.authenticationURL();
			fail();
		}catch(TwitterProviderException e){
			assertThat(e.getMessage(),containsString("AuthenticationRelevant"));
		}
		
		verifyTwitter4jRequestToken();

	}
	@Test
	@Ignore
	public void obtaining_an_authentication_url_with_access_token() throws TwitterException {
		
		//TODO I need to change this protected property or I will go to hell
		twitterProvider.accessToken = accessToken;
//		doThrow(new IllegalStateException("consumer key/secret pair already set")).when(twitter4j).setOAuthConsumer(consumerKey,consumerSecret);
		when(twitter4j.getOAuthRequestToken(returnUrl)).thenReturn(requestToken);
			
		String urlExpected = twitterProvider.authenticationURL();
		assertNotNull(urlExpected);
		verify(twitter4j,never()).setOAuthConsumer(consumerKey, consumerSecret);
		verify(twitter4j).getOAuthRequestToken(returnUrl);
		
		

	}
	
	@Test
	public void verify_credentials() throws TwitterException, MalformedURLException{
		
		
		RequestToken requestToken = null;
		AccessToken accessToken = null;
		User userExpected = mock(User.class);
		
		when(twitter4j.getOAuthAccessToken(requestToken, oauth_verifier)).thenReturn(accessToken);
		when(twitter4j.verifyCredentials()).thenReturn(userExpected);
		when(userExpected.getName()).thenReturn("ialcazar");
		when(userExpected.getScreenName()).thenReturn("ISRAEL");
		when(userExpected.getProfileImageURL()).thenReturn(new URL("http://src/imgs"));
		

		
		MojitoUser mojitoUser = twitterProvider.verifyCredentials(oauth_verifier);
		
		
		assertNotNull(mojitoUser);
		verify(twitter4j).getOAuthAccessToken(requestToken, oauth_verifier);
		verify(twitter4j).verifyCredentials();
		

	}
	@Test
	public void verify_credentials_throws_exception() throws TwitterException{
		
		
		RequestToken requestToken = null;
		MojitoUser mojitoUserExpected = null;
		
		
		when(twitter4j.getOAuthAccessToken(requestToken, oauth_verifier)).thenThrow(new TwitterException("AuthenticationRelevant discussions can be on the Internet at"));
		
		try{
			mojitoUserExpected = twitterProvider.verifyCredentials(oauth_verifier);
			fail();
		}catch(TwitterProviderException e){
			assertThat(e.getMessage(),containsString("AuthenticationRelevant"));
		}
		
		
		assertNull(mojitoUserExpected);
		verify(twitter4j).getOAuthAccessToken(requestToken, oauth_verifier);
	}


}
