package com.mf.site.services.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mf.site.exceptions.ServiceException;
import com.mf.site.exceptions.TwitterProviderException;
import com.mf.site.model.MojitoUser;
import com.mf.site.providers.TwitterProvider4j;
import com.mf.site.services.TwitterService;

@Service
public class TwitterServiceT4j implements TwitterService{
	
	private TwitterProvider4j  twitterProvider;
	
	@Inject
	public TwitterServiceT4j(TwitterProvider4j twitterProvider) {
		this.twitterProvider = twitterProvider;
		
	}
	public String authenticate() throws ServiceException{
			
			String url = null;
			try{
				url = twitterProvider.authenticationURL();
			}catch(TwitterProviderException e){
				throw new ServiceException(e);
			}catch(Exception e){
				throw new ServiceException(e);
			}
			return url;
		
	}
	public MojitoUser verifyCredentials(String oauth_verifier) {
		
		return twitterProvider.verifyCredentials(oauth_verifier);
	}

}
