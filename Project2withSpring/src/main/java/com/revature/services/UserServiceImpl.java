package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository ur;

	@Override
	public List<User> findAllUsers() {
		return ur.findAll();
	}

	@Override
	public User findUserById(Integer id) {
		return ur.getOne(id);
	}

	@Override
	public User addUser(User h) {
		return ur.save(h);
	}

	@Override
	public User updateUser(User h) {
		return ur.save(h);
	}

	@Override
	public User deleteUser(User h) {
		ur.delete(h);
		return h;
	}

	@Override
	public User findUserByUsernameAndPassword(String u, String p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByEmailAndPassword(String e, String p) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
