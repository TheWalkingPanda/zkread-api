package com.zkread.service.interfaces;

import java.util.List;

import com.zkread.domain.User;

public interface IUserSV {
	public long saveUser(User newUser);
	public int delUser(long userId);
	public int updateUser(User updateUser);
	public User getUserById(long userId);
	public List<User> getUsersByParam(User paramUser);
}
