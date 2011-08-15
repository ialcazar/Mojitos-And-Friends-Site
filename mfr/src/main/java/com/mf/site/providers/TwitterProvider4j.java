package com.mf.site.providers;

import com.mf.site.model.MojitoUser;



public interface TwitterProvider4j {

	String authenticationURL();

	MojitoUser verifyCredentials(String oauth_verifier);

}
