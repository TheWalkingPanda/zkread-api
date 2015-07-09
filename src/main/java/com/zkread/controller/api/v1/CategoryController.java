package com.zkread.controller.api.v1;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zkread.domain.Article;
import com.zkread.service.interfaces.ICategorySV;
import com.zkread.util.Return;

@Controller
@RequestMapping("/api/v1")
public class CategoryController {
	private static Log log = LogFactory.getLog(CategoryController.class);
	
	@Autowired
	private ICategorySV categorySV;
	
	@RequestMapping(value="/categorys/{categoryId}/articles", method=RequestMethod.GET)
	@ResponseBody
	public Return getCategoryArticles(@PathVariable("categoryId") long categoryId){
		Return ret = new Return();
		try {
			List<Article> articleList = categorySV.getCategoryArticles(categoryId);
			
			ret.setSuccess(true);
			if(articleList!=null && articleList.size()>0){
				ret.setData(articleList);
			}else{
				ret.setMessage("category[id="+categoryId+"]不存在article！]");
			}
		} catch (Exception e) {
			log.error(e);
			ret.setSuccess(false);
			ret.setMessage("请求异常："+e.toString());
		}
		return ret;
	}
	
}
