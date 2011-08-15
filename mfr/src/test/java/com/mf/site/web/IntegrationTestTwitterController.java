package com.mf.site.web;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;

import com.mf.site.web.TwitterController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/testContext.xml"})
public class IntegrationTestTwitterController {
	@Inject
	private TwitterController twitterController;
	
	@Test
	public void login_with_twitter_first_time(){
		MockHttpServletRequest request = new MockHttpServletRequest("GET", "/twitter");
		String redirectExpected = "redirect:http://api.twitter.com/oauth/authenticate";
		
		
		String redirect = twitterController.authenticate(request);
		
		assertNotNull(twitterController);
		assertThat(redirect,startsWith(redirectExpected));
		
	}
	
	
	@Test
	@Ignore
	public void callback_from_twitter_with_oauth_verifier(){
		MockHttpServletRequest request = new MockHttpServletRequest("GET", "/twitter/callback");
		request.setParameter("oauth_verifier", "329179375-wqTDZHzzsmits7PTSQ8ng8di2FRasmlt0cQP0txP");
		Model model = mock(Model.class); 
	   
		String redirectExpected = "redirect:/";
		
		
		
		String redirectUrl = twitterController.callback(request,model);
		
		assertThat(redirectUrl,equalTo(redirectExpected));
		 
	}
	@Test
	public void callback_from_twitter_access_denied(){
		String deniedParameterName ="denied";
		String deniedParameterValue ="denied";
		String redirectExpected = "redirect:/twitter/error";
		MockHttpServletRequest request = new MockHttpServletRequest("GET", "/twitter/callback");
		request.setParameter(deniedParameterName, deniedParameterValue);
		Model model = mock(Model.class); 
		
		
		
		
		String redirectUrl = twitterController.callback(request,model);
		
		assertThat(redirectUrl,equalTo(redirectExpected));
		
		verify(model).addAttribute("message", "Acceso Denegado");
		 
	}

}
