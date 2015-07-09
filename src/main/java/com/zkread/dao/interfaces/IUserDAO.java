package com.zkread.dao.interfaces;

import java.util.List;

import com.zkread.domain.User;

public interface IUserDAO {
	public long saveUser(User user);
	public int delUser(long userId);
	public int updateUser(User user);
	public User getUserById(long userId);
	public List<User> getUsersByParam(User paramUser);
}
