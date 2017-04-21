package com.zd.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zd.bean.Favorite;
import com.zd.bean.Tag;
import com.zd.biz.FavoriteBiz;
import com.zd.biz.TagBiz;
import com.zd.biz.impl.FavoriteBizImpl;
import com.zd.biz.impl.TagBizImpl;
import com.zd.web.model.JsonModel;
/**
 * index页面加载时要两次ajax  这里将他合并
 * @author Administrator
 *
 */
public class IndexServlet extends BasicServlet{
	private static final long serialVersionUID = 1L;
	private TagBiz tb=new TagBizImpl();
	private FavoriteBiz fb=new FavoriteBizImpl();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if("SelectIndex".equals(op)){
				SelectIndexOp(request,response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	private void SelectIndexOp(HttpServletRequest request, HttpServletResponse response) throws IOException {
		JsonModel jm=new JsonModel();
		List<Object> list;
		try {
			List<Tag> list1=tb.findAllTag();
			List<Favorite> list2=fb.findFavoriteAll();
			
			list = new ArrayList<Object>();
			list.add(list1);
			list.add(list2);
			jm.setCode(1);
			jm.setObj(list);
		} catch (Exception e) {
			e.printStackTrace();
			jm.setCode(0);
			jm.setErrorMsg("查询出错....");
		}finally{
			super.outJson(jm, response);
		}
		
	}

	
	
	
}
