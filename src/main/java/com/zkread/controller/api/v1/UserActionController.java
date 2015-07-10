package com.zkread.controller.api.v1;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zkread.domain.UserAction;
import com.zkread.service.interfaces.IUserActionSV;
import com.zkread.util.DataState;
import com.zkread.util.DateUtil;
import com.zkread.util.Return;

@Controller
@RequestMapping("/api/v1")
public class UserActionController {
	private static Log log = LogFactory.getLog(UserActionController.class);
	
	@Autowired
	private IUserActionSV actionSV;

	@RequestMapping(value="/actions", method=RequestMethod.POST)
	@ResponseBody
	public Return saveUserAction(@RequestBody MultiValueMap<String, String> requestMap){
		Return ret = new Return();
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UserAction newAction = objectMapper.readValue(objectMapper.writeValueAsString(requestMap.toSingleValueMap()), UserAction.class);
			
			newAction.setCreateTime(DateUtil.getCurrentDate());
			newAction.setState(DataState.DATA_STATE_U);
			
			actionSV.saveUserAction(newAction);
			
			ret.setSuccess(true);
			ret.setData(newAction);
		} catch (Exception e) {
			log.error(e);
			ret.setSuccess(false);
			ret.setMessage("请求异常："+e.toString());
		}
		return ret;
	}
	
	@RequestMapping(value="/actions", method=RequestMethod.GET)
	@ResponseBody
	public Return getUserActions(@RequestBody MultiValueMap<String, String> requestMap){
		Return ret = new Return();
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UserAction paramAction = objectMapper.readValue(objectMapper.writeValueAsString(requestMap.toSingleValueMap()), UserAction.class);
			
			List<UserAction> actionList = actionSV.getUserActionsByParam(paramAction);
			
			ret.setSuccess(true);
			if(actionList!=null && actionList.size()>0){
				ret.setData(actionList);
			}else{
				ret.setMessage("不存在此类UserAction["+objectMapper.writeValueAsString(paramAction)+"！]");
			}
		} catch (Exception e) {
			log.error(e);
			ret.setSuccess(false);
			ret.setMessage("请求异常："+e.toString());
		}
		return ret;
	}
	
}
