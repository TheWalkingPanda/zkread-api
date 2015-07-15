package com.zkread.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zkread.dao.interfaces.ICommonDAO;
import com.zkread.domain.User;
import com.zkread.service.interfaces.IUserSV;

@Service
public class UserSVImpl implements IUserSV {

	@Autowired
	private ICommonDAO<User> commonDao;
	
	public long saveUser(User user) {
		return commonDao.save(user);
	}

	public int delUser(long userId) {
		User delUser = new User();
		delUser.setId(userId);
		return commonDao.del(delUser);
	}

	public int updateUser(User user) {
		return commonDao.update(user);
	}

	public User getUserById(long userId) {
		User theUser = new User();
		theUser.setId(userId);
		return commonDao.getById(theUser);
	}

	public List<User> getUsersByParam(User paramUser) {
		return commonDao.getByParam(paramUser);
	}
	
}
