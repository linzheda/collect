package com.zd.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zd.bean.Tag;
import com.zd.biz.TagBiz;
import com.zd.biz.impl.TagBizImpl;
import com.zd.web.model.JsonModel;

public class TagServlet extends BasicServlet{

	private static final long serialVersionUID = 1L;
	private TagBiz tb=new TagBizImpl();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if("selectTagAll".equals(op)){//查询所有标签
				selectTagAllOp(request,response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	

	private void selectTagAllOp(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		JsonModel jm=new JsonModel();
		List<Tag> list;
		try {
			list = tb.findAllTag();
			jm.setCode(1);
			jm.setObj(list);
		} catch (Exception e) {
			e.printStackTrace();
			jm.setCode(0);
			jm.setErrorMsg("查询tag出错....");
		}finally{
			super.outJson(jm, response);
		}
		
		
	}

}
