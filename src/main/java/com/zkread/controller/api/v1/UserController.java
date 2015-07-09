package com.zkread.controller.api.v1;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zkread.domain.User;
import com.zkread.service.interfaces.IUserSV;
import com.zkread.util.DataState;
import com.zkread.util.DateUtil;
import com.zkread.util.RequestUtil;
import com.zkread.util.Return;

@Controller
@RequestMapping("/api/v1")
public class UserController {
	private static Log log = LogFactory.getLog(UserController.class);
	
	@Autowired
	private IUserSV userSV;
	
	@RequestMapping(value="/users", method=RequestMethod.POST)
	@ResponseBody
	public Return addUser(HttpServletRequest request){
		Return ret = new Return();
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			User newUser = objectMapper.readValue(RequestUtil.getRequestBeanJson(request), User.class);
			
			newUser.setCreateTime(DateUtil.getCurrentDate());
			newUser.setState(DataState.DATA_STATE_U);
			
			userSV.saveUser(newUser);
			
			ret.setSuccess(true);
			ret.setData(newUser);
		} catch (Exception e) {
			log.error(e);
			ret.setSuccess(false);
			ret.setMessage("请求异常："+e.toString());
		}
		return ret;
	}
	
	@RequestMapping(value="/users/{userId}", method=RequestMethod.DELETE)
	@ResponseBody
	public Return delUser(@PathVariable("userId") long userId){
		Return ret = new Return();
		try {
			userSV.delUser(userId);
			ret.setSuccess(true);
		} catch (Exception e) {
			log.error(e);
			ret.setSuccess(false);
			ret.setMessage("请求异常："+e.toString());
		}
		return ret;
	}
	
	@RequestMapping(value="/users/{userId}", method=RequestMethod.PUT)
	@ResponseBody
	public Return updateUser(@PathVariable("userId") long userId, HttpServletRequest request){
		Return ret = new Return();
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			User updateUser = objectMapper.readValue(RequestUtil.getRequestBeanJson(request), User.class);
			
			updateUser.setId(userId);
			
			userSV.updateUser(updateUser);
			
			ret.setSuccess(true);
		} catch (Exception e) {
			log.error(e);
			ret.setSuccess(false);
			ret.setMessage("请求异常："+e.toString());
		}
		return ret;
	}
	
	@RequestMapping(value="/users/{userId}", method=RequestMethod.GET)
	@ResponseBody
	public Return getUser(@PathVariable("userId") long userId) {
		Return ret = new Return();
		try {
			User user = userSV.getUserById(userId);
			ret.setSuccess(true);
			
			if(user!=null){
				ret.setData(user);
			}else{
				ret.setMessage("user[id="+userId+"]不存在！");
			}
		} catch (Exception e) {
			log.error(e);
			ret.setSuccess(false);
			ret.setMessage("请求异常："+e.toString());
		}
		return ret;
	}
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	@ResponseBody
	public Return getUsers(HttpServletRequest request){
		Return ret = new Return();
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			User paramUser = objectMapper.readValue(RequestUtil.getRequestBeanJson(request), User.class);
			
			List<User> userList = userSV.getUsersByParam(paramUser);
			
			ret.setSuccess(true);
			if(userList!=null && userList.size()>0){
				ret.setData(userList);
			}else{
				ret.setMessage("不存在此类user["+objectMapper.writeValueAsString(paramUser)+"！]");
			}
		} catch (Exception e) {
			log.error(e);
			ret.setSuccess(false);
			ret.setMessage("请求异常："+e.toString());
		}
		return ret;
	}
}
