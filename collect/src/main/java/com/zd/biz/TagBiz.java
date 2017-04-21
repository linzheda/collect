package com.zd.biz;

import java.util.List;

import com.zd.bean.Tag;

public interface TagBiz {
	public Tag findTagByTname(String name);
	public List<Tag> findAllTag() throws Exception;
	
	
	
}
