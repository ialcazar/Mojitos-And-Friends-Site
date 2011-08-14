package com.mf.site.providers;

import com.mf.site.model.MojitoUser;



public interface TwitterProvider {

	String authenticationURL();

	MojitoUser verifyCredentials(String oauth_verifier);

}
