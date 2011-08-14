package com.mf.site.web;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mf.site.web.TwitterController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/testContext.xml"})
public class IntegrationTestTwitterController {
	@Inject
	private TwitterController twitterController;
	
	@Test
	public void login_with_twitter_is_ok() {
		String redirectExpected = "redirect:http://api.twitter.com/oauth/authenticate";
		
		
		String redirect = twitterController.authenticate();
		
		assertNotNull(twitterController);
		assertThat(redirect,startsWith(redirectExpected));
		
	}
	
//	@Test
//	public void callback_from_twitter_is_ok(){
//		String redirectExpected = "redirect:/";
//		
//		String redirect = twitterController.callback();
//		
//		assertNotNull(twitterController);
//		assertThat(redirect,startsWith(redirectExpected));
//		
//	}

}
