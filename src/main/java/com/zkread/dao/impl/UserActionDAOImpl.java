package com.zkread.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.zkread.dao.interfaces.IUserActionDAO;
import com.zkread.domain.UserAction;

@Repository
public class UserActionDAOImpl implements IUserActionDAO {

	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;
	
	public long saveUserAction(UserAction userAction) {
		Object result = sqlMapClientTemplate.insert("saveUserAction", userAction);
		return Long.parseLong(result.toString());
	}

	public UserAction getUserActionById(long userActionId) {
		return (UserAction) sqlMapClientTemplate.queryForObject("getUserActionById", userActionId);
	}

	@SuppressWarnings("unchecked")
	public List<UserAction> getUserActionsByParam(UserAction paramUserAction) {
		return sqlMapClientTemplate.queryForList("getUserActionsByParam", paramUserAction);
	}

}
