package com.zkread.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class RequestUtil {
	
	public static String getRequestBeanJson(HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, String[]> objMap = request.getParameterMap();
		
		Map<String, String> resultMap = new HashMap<String, String>();
		for(String key : objMap.keySet()){
			String value = objMap.get(key)[0];
			resultMap.put(key, value);
		}
		
		return objectMapper.writeValueAsString(resultMap);
	}
}
