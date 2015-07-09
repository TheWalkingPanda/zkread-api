package com.zkread.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zkread.dao.interfaces.IUserDAO;
import com.zkread.domain.User;
import com.zkread.service.interfaces.IUserSV;

@Service
public class UserSVImpl implements IUserSV {

	@Autowired
	private IUserDAO userDao;
	
	public long saveUser(User user) {
		return userDao.saveUser(user);
	}

	public int delUser(long userId) {
		return userDao.delUser(userId);
	}

	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

	public User getUserById(long userId) {
		return userDao.getUserById(userId);
	}

	public List<User> getUsersByParam(User paramUser) {
		return userDao.getUsersByParam(paramUser);
	}
	
}
