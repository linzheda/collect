package com.zd.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zd.bean.Favorite;
import com.zd.biz.FavoriteBiz;
import com.zd.biz.impl.FavoriteBizImpl;
import com.zd.web.model.JsonModel;

public class FavoriteServlet extends BasicServlet{
	private static final long serialVersionUID = 1L;
	private FavoriteBiz fb=new FavoriteBizImpl();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if("SelectFavAll".equals(op)){
				SelectFavAllOP(request,response);
			}else if("SelectOne".equals(op)){
				SelectOneOp(request,response);
			}else if("addFav".equals(op)){
				addFav(request,response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}

	private void addFav(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String label=request.getParameter("label");
		String url=request.getParameter("url");
		String tags=request.getParameter("tags");
		String desc=request.getParameter("desc");
		Favorite fav=new Favorite();
		fav.setLabel(label);
		fav.setUrl(url);
		fav.setTags(tags);
		fav.setDesc(desc);
		boolean flag=fb.addFavorite(fav);
		JsonModel jm=new JsonModel();
		
		
		if(flag==false){
			jm.setCode(0);
		}else{
			jm.setCode(1);
		}
		super.outJson(jm, response);
	}

	private void SelectOneOp(HttpServletRequest request, HttpServletResponse response) throws IOException {
		JsonModel jm=new JsonModel();
		List<Favorite> list;
		try {
			String tagname=request.getParameter("tagname");
			list = fb.findFavoriteByTagName(tagname);
			jm.setCode(1);
			jm.setObj(list);
		} catch (Exception e) {
			e.printStackTrace();
			jm.setCode(0);
			jm.setErrorMsg("查询fav出错....");
		}finally{
			super.outJson(jm, response);
		}
		
		
	}

	private void SelectFavAllOP(HttpServletRequest request, HttpServletResponse response) throws IOException {
		JsonModel jm=new JsonModel();
		List<Favorite> list;
		try {
			list = fb.findFavoriteAll();
			jm.setCode(1);
			jm.setObj(list);
		} catch (Exception e) {
			e.printStackTrace();
			jm.setCode(0);
			jm.setErrorMsg("查询fav出错....");
		}finally{
			super.outJson(jm, response);
		}
		
		
	}
	
}
