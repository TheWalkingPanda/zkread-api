package com.zkread.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zkread.dao.interfaces.IUserActionDAO;
import com.zkread.domain.UserAction;
import com.zkread.service.interfaces.IUserActionSV;

@Service
public class UserActionSVImpl implements IUserActionSV {

	@Autowired
	private IUserActionDAO userActionDao;
	
	public long saveUserAction(UserAction userAction) {
		return userActionDao.saveUserAction(userAction);
	}

	public UserAction getUserActionById(long userActionId) {
		return userActionDao.getUserActionById(userActionId);
	}

	public List<UserAction> getUserActionsByParam(UserAction paramUserAction) {
		return userActionDao.getUserActionsByParam(paramUserAction);
	}

}
