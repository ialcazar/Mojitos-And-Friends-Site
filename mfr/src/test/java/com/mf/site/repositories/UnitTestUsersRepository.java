package com.mf.site.repositories;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import twitter4j.auth.RequestToken;

import com.mf.site.model.MojitoUser;
import com.mf.site.repositories.impl.UsersRepositoryMemoryImpl;

public class UnitTestUsersRepository {
	
	private Map<String,MojitoUser> dbmemory; 
	private UsersRepositoryMemoryImpl usersRepository;
	@Before
	public void setUp(){
		dbmemory = new HashMap<String,MojitoUser>();
		dbmemory.put("sjimenez", new MojitoUser("sjimenez","sjimenez","sjimenez","sjimenez"));
		usersRepository = new UsersRepositoryMemoryImpl(dbmemory);
	}
	
	@Test
	public void get_user_by_id_exists_user(){
		
		UsersRepositoryMemoryImpl usersRepository = new UsersRepositoryMemoryImpl(dbmemory);
		
		MojitoUser userExpected = usersRepository.getUserById("sjimenez");
		assertNotNull(userExpected);
	}
	
	@Test
	public void get_user_by_id_not_exists_user(){			
		MojitoUser userExpected = usersRepository.getUserById("sjimenez2");
		assertNull(userExpected);
	}
	@Test
	public void save_user_with_request_token() {
		MojitoUser user = new MojitoUser("ialcazar","Israel Alcázar","Israel Alcázar","img");
		RequestToken requestToken = new RequestToken("1234","1234");
		user.setRequestToken(requestToken);
		
		int numOfUsersBefore = dbmemory.size();
		
		usersRepository.save(user);
		
		int numOfUsersAfter = dbmemory.size();
		
		MojitoUser userExpected = dbmemory.get(user.getTwitterId());
		
		assertThat(numOfUsersAfter,is(equalTo(numOfUsersBefore+1)));
		assertThat(user,is(equalTo(userExpected)));
		
		
		
	}
	
	@Test
	public void save_user_duplicated_user() {
		MojitoUser user = new MojitoUser("sjimenez","sjimenez","sjimenez","sjimenez");
		
		int numOfUsersBefore = dbmemory.size();
		
		usersRepository.save(user);
		
		int numOfUsersAfter = dbmemory.size();
		

		assertThat(numOfUsersAfter,is(equalTo(numOfUsersBefore)));
				
	}
	
	

}
