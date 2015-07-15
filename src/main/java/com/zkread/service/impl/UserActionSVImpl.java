package com.zkread.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zkread.dao.interfaces.ICommonDAO;
import com.zkread.domain.UserAction;
import com.zkread.service.interfaces.IUserActionSV;

@Service
public class UserActionSVImpl implements IUserActionSV {

	@Autowired
	private ICommonDAO<UserAction> commonDao;
	
	public long saveUserAction(UserAction newAction) {
		return commonDao.save(newAction);
	}

	public UserAction getUserActionById(long userActionId) {
		UserAction theAction = new UserAction();
		theAction.setId(userActionId);
		return commonDao.getById(theAction);
	}

	public List<UserAction> getUserActionsByParam(UserAction paramUserAction) {
		return commonDao.getByParam(paramUserAction);
	}

}
