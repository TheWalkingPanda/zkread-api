package com.zkread.service.interfaces;

import java.util.List;

import com.zkread.domain.UserAction;

public interface IUserActionSV {
	public long saveUserAction(UserAction newAction);
	public UserAction getUserActionById(long userActionId);
	public List<UserAction> getUserActionsByParam(UserAction paramUserAction);
}
