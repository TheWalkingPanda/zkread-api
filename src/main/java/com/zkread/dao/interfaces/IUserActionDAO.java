package com.zkread.dao.interfaces;

import java.util.List;

import com.zkread.domain.UserAction;

public interface IUserActionDAO {
	public long saveUserAction(UserAction userAction);
	public UserAction getUserActionById(long userActionId);
	public List<UserAction> getUserActionsByParam(UserAction paramUserAction);
}
