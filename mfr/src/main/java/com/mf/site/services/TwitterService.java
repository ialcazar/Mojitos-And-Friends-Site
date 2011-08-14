package com.mf.site.services;

import com.mf.site.exceptions.ServiceException;
import com.mf.site.model.MojitoUser;

public interface TwitterService {
	String authenticate() throws ServiceException;
	MojitoUser verifyCredentials(String oauth_verifier);
}
