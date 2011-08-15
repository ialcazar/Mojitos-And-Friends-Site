package com.mf.site.repositories.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mf.site.model.MojitoUser;
import com.mf.site.repositories.UsersRepository;

@Repository
public class UsersRepositoryMemoryImpl implements UsersRepository{
	private Map<String,MojitoUser> users;
	
	public UsersRepositoryMemoryImpl(){
		this(new HashMap<String,MojitoUser>());
	}
	public UsersRepositoryMemoryImpl(Map<String, MojitoUser> dbmemory) {
		users = dbmemory;
	}
	
	public void save(MojitoUser user) {
		users.put(user.getTwitterId(), user);
		
	}
	
	public MojitoUser getUserById(String twitterId) {
		
		return users.get(twitterId);
	}

}
