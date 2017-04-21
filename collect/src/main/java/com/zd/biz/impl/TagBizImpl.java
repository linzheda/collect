package com.zd.biz.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.zd.bean.Tag;
import com.zd.biz.TagBiz;
import com.zd.dao.MyBatisHelper;

public class TagBizImpl implements TagBiz{

	@Override
	public Tag findTagByTname(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tag> findAllTag() throws Exception {
		SqlSession s=MyBatisHelper.getSession();
    	List<Tag> list=s.selectList("com.zd.mapper.TagMapper.selectTagAll");
    	s.commit();//为了二级缓存
		return list;
	}

}
