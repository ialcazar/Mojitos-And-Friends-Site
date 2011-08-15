package com.mf.site.repositories;

import com.mf.site.model.MojitoUser;

public interface UsersRepository {
	void save(MojitoUser user);
	MojitoUser getUserById(String twitterId);
}
