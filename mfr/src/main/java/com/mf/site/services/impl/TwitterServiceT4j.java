package com.mf.site.services.impl;

import com.mf.site.exceptions.ServiceException;
import com.mf.site.exceptions.TwitterProviderException;
import com.mf.site.model.MojitoUser;
import com.mf.site.providers.TwitterProvider;








public class TwitterServiceT4j {
	private TwitterProvider  twitterProvider;
	

	public TwitterServiceT4j(TwitterProvider twitterProvider) {
		this.twitterProvider = twitterProvider;
		
	}
	public String signin() throws ServiceException{
			
			String url = null;
			try{
				url = twitterProvider.authenticationURL();
			}catch(TwitterProviderException e){
				throw new ServiceException(e);
			}
			
			return url;
		
	}
	public MojitoUser verifyCredentials(String oauth_verifier) {
		
		return twitterProvider.verifyCredentials(oauth_verifier);
	}

}
