package com.mf.site.web;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.mf.site.exceptions.ServiceException;
import com.mf.site.exceptions.TwitterProviderException;
import com.mf.site.model.MojitoUser;
import com.mf.site.providers.TwitterProvider4j;
import com.mf.site.services.TwitterService;
import com.mf.site.services.impl.TwitterServiceT4j;

public class UnitTestTwitterController {

	private TwitterService twitterService;
	private TwitterController twitterController;
	private HttpSession session ;
	private HttpServletRequest request;
	private Model model;
	private MojitoUser mojitoUser ;
	
	@Before
	public void setUp(){
		createMocksObjects();
	}

	private void createMocksObjects() {
		twitterService  = mock(TwitterService.class);
		twitterController = new TwitterController(twitterService);
		session = mock(HttpSession.class);
		request = mock(HttpServletRequest.class);
		model = mock(Model.class);
		mojitoUser = mock(MojitoUser.class);
	}

	@Test
	public void login_with_twitter_first_time()  {
		String authenticationUrlExpected = "redirect:http://api.twitter.com/oauth/authenticate";
		
		when(request.getSession(true)).thenReturn(session);
		when(session.getAttribute("mojitoUser")).thenReturn(null);
		when(twitterService.authenticate()).thenReturn("http://api.twitter.com/oauth/authenticate");
		
		//ACT

		String authenticationUrl = twitterController.authenticate(request);
		
		//ASSERTS
		verify(request).getSession(true);
		verify(session).getAttribute("mojitoUser");
		verify(twitterService).authenticate();
		assertThat(authenticationUrl,equalTo(authenticationUrlExpected));
		

	}
	@Test
	public void login_with_twitter_when_user_is_logged()  {
		String authenticationUrlExpected = "redirect:/";
		
		when(request.getSession(true)).thenReturn(session);
		when(session.getAttribute("mojitoUser")).thenReturn(mojitoUser);
		//ACT

		String authenticationUrl = twitterController.authenticate(request);
		
		//ASSERTS
		verify(request).getSession(true);
		verify(session).getAttribute("mojitoUser");
		assertThat(authenticationUrl,equalTo(authenticationUrlExpected));
		

	}
	
	@Test
	public void callback_from_twitter_with_oauth_verifier(){
		
		String oauthVerifierValue ="1234";
		String oauthVerifierParameterName ="oauth_verifier";
		String redirectExpected = "redirect:/";
		
		
		when(request.getParameter(oauthVerifierParameterName)).thenReturn(oauthVerifierValue);
		when(twitterService.verifyCredentials(oauthVerifierValue)).thenReturn(mojitoUser);
		when(request.getSession(true)).thenReturn(session);
		
		String redirectUrl = twitterController.callback(request,model);
		
		assertThat(redirectUrl,equalTo(redirectExpected));
		verify(request).getParameter(oauthVerifierParameterName);
		verify(twitterService).verifyCredentials(oauthVerifierValue);
		verify(request).getSession(true);
		verify(session).setAttribute("mojitoUser", mojitoUser);
		 
	}
	

	@Test
	public void callback_from_twitter_without_oauth_verifier(){
		
		String oauthVerifierParameterName ="oauth_verifier";
		String redirectExpected = "redirect:/twitter/error";
		
		when(request.getParameter(oauthVerifierParameterName)).thenReturn(null);
		
		String redirectUrl = twitterController.callback(request,model);
		
		assertThat(redirectUrl,equalTo(redirectExpected));
		verify(request).getParameter(oauthVerifierParameterName);
		 
	}
	
	@Test
	public void callback_from_twitter_access_denied(){
		
		String deniedParameterName ="denied";
		String deniedParameterValue ="denied";
		String redirectExpected = "redirect:/twitter/error";
		
		when(request.getParameter(deniedParameterName)).thenReturn(deniedParameterValue);
		
		String redirectUrl = twitterController.callback(request,model);
		
		assertThat(redirectUrl,equalTo(redirectExpected));
		verify(request).getParameter(deniedParameterName);
		verify(model).addAttribute("message", "Acceso Denegado");
		 
	}
	
}
