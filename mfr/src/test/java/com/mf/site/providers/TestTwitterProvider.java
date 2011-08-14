package com.mf.site.providers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.auth.RequestToken;


import com.mf.site.exceptions.TwitterProviderException;
import com.mf.site.model.MojitoUser;
import com.mf.site.providers.impl.TwitterProviderT4j;


public class TestTwitterProvider {
	
	@Test
	public void obtaining_an_authentication_url() throws TwitterException {
		Twitter twitter4j = mock(Twitter.class);
		RequestToken requestToken = new RequestToken(null,null);
		
		String consumerKey = "Mq8IGEgB2wGcNCA2Qh3KPw";
		String consumerSecret = "xFTscxX9WEkQNUtVaTm4ZaCm8xTkU7yBTK4UZCuss";
		String returnUrl = "http://localhost/mfr/twitter/callback";
		
		when(twitter4j.getOAuthRequestToken(returnUrl)).thenReturn(requestToken);
		
		
		TwitterProvider twitterProvider = new TwitterProviderT4j(twitter4j,returnUrl);
		
		String urlExpected = twitterProvider.authenticationURL();
		
		assertNotNull(urlExpected);
		System.out.println(urlExpected);
		
		verify(twitter4j).setOAuthConsumer(consumerKey,consumerSecret);
		
		verify(twitter4j).getOAuthRequestToken(returnUrl);
//		verify(requestToken).getAuthenticationURL();

		
	}
	
	@Test
	public void obtaining_an_authentication_url_throws_exception() throws TwitterException {
		Twitter twitter4j = mock(Twitter.class);
		
		
		String consumerKey = "Mq8IGEgB2wGcNCA2Qh3KPw";
		String consumerSecret = "xFTscxX9WEkQNUtVaTm4ZaCm8xTkU7yBTK4UZCuss";
		String returnUrl = "http://localhost/mfr/twitter/callback";
		
		when(twitter4j.getOAuthRequestToken(returnUrl)).thenThrow(new TwitterException("AuthenticationRelevant discussions can be on the Internet at"));
		
		
		TwitterProvider twitterProvider = new TwitterProviderT4j(twitter4j,returnUrl);
		
		try{
			twitterProvider.authenticationURL();
			fail();
		}catch(TwitterProviderException e){
			assertThat(e.getMessage(),containsString("AuthenticationRelevant"));
		}
		
		verify(twitter4j).setOAuthConsumer(consumerKey,consumerSecret);
		
		verify(twitter4j).getOAuthRequestToken(returnUrl);
//		verify(requestToken).getAuthenticationURL();

	}
	
	@Test
	public void verify_credentials() throws TwitterException, MalformedURLException{
		String oauth_verifier ="1243";
		Twitter twitter4j = mock(Twitter.class);
		String returnUrl = "http://localhost/mfr/twitter/callback";
		RequestToken requestToken = null;
		User userExpected = mock(User.class);
		
		when(twitter4j.getOAuthRequestToken(returnUrl)).thenReturn(requestToken);
		when(twitter4j.verifyCredentials()).thenReturn(userExpected);
		when(userExpected.getName()).thenReturn("ialcazar");
		when(userExpected.getScreenName()).thenReturn("ISRAEL");
		when(userExpected.getProfileImageURL()).thenReturn(new URL("http://src/imgs"));
		
		TwitterProvider twitterProvider = new TwitterProviderT4j(twitter4j,returnUrl);
		
		MojitoUser mojitoUser = twitterProvider.verifyCredentials(oauth_verifier);
		
		
		assertNotNull(mojitoUser);
		verify(twitter4j).getOAuthAccessToken(requestToken, oauth_verifier);
		verify(twitter4j).verifyCredentials();
		

	}
	@Test
	public void verify_credentials_throws_exception(){
		fail(); 
	}


}
