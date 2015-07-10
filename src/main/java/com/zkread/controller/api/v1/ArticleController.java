package com.zkread.controller.api.v1;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zkread.domain.Article;
import com.zkread.service.interfaces.IArticleSV;
import com.zkread.util.DataState;
import com.zkread.util.DateUtil;
import com.zkread.util.Return;

@Controller
@RequestMapping("/api/v1")
public class ArticleController {
	private static Log log = LogFactory.getLog(ArticleController.class);
	
	@Autowired
	private IArticleSV articleSV;
	
	@RequestMapping(value="/articles", method=RequestMethod.POST)
	@ResponseBody
	public Return saveArticle(@RequestBody MultiValueMap<String, String> requestMap){
		Return ret = new Return();
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			Article newArticle = objectMapper.readValue(objectMapper.writeValueAsString(requestMap.toSingleValueMap()), Article.class);
			
			newArticle.setCreateTime(DateUtil.getCurrentDate());
			newArticle.setState(DataState.DATA_STATE_U);
			
			articleSV.saveArticle(newArticle);
			
			ret.setSuccess(true);
			ret.setData(newArticle);
		} catch (Exception e) {
			log.error(e);
			ret.setSuccess(false);
			ret.setMessage("请求异常："+e.toString());
		}
		return ret;
	}
	
	@RequestMapping(value="/articles/{articleId}", method=RequestMethod.GET)
	@ResponseBody
	public Return getArticle(@PathVariable("articleId") long articleId){
		Return ret = new Return();
		try {
			Article article = articleSV.getArticleById(articleId);
			ret.setSuccess(true);
			
			if(article!=null){
				ret.setData(article);
			}else{
				ret.setMessage("user[id="+articleId+"]不存在！");
			}
		} catch (Exception e) {
			log.error(e);
			ret.setSuccess(false);
			ret.setMessage("请求异常："+e.toString());
		}
		return ret;
	}
}
