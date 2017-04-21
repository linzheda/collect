package com.zd.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.zd.bean.Favorite;
import com.zd.bean.Tag;
import com.zd.biz.FavoriteBiz;
import com.zd.dao.MyBatisHelper;

public class FavoriteBizImpl implements FavoriteBiz {

	@Override
	public boolean addFavorite(Favorite fav) throws Exception {
		boolean flag=false;
		SqlSession s=MyBatisHelper.getSession();
		try {
			String tags=fav.getTags();
			if(tags.equals("")||tags.equals("null")){
				fav.setTags("未分类");
			}else{
				String regex = ",|，|\\s+";
				String[]tag=tags.split(regex); 
								//Tag.class.getName()  ->  "com.zd.bean.Tag"+Mapper
				List<Tag> lt=s.selectList("com.zd.mapper.TagMapper.selectTagAll");
				Map<String,String> map=new HashMap<String,String>();
				for(int i=0,len=lt.size();i<len;i++){//将tagName存到map中
					map.put(lt.get(i).getName(), null);
				}
				for(int i=0,len=tag.length;i<len;i++){//比对是否存在tag
					boolean exist=map.containsKey(tag[i]);
					if(exist){//存在则更新数量
						s.update("com.zd.mapper.TagMapper.updateTag",tag[i]);
					}else{//不存在则插入值
						s.insert("com.zd.mapper.TagMapper.addTag",tag[i]);
					}
				}
				
			}
			//fav.setTags(","+fav.getTags()+",");
			s.insert("com.zd.mapper.FavoriteMapper.addFav",fav);
			flag=true;
			s.commit();
		} catch (Exception e) {
			s.rollback();
			e.printStackTrace();
			throw e;
		}
		return flag;
		
	}

	@Override
	public List<Favorite> findFavoriteByTagName(String tagName) throws Exception {
		SqlSession s=MyBatisHelper.getSession();
		if(null!=tagName &&  !tagName.equals("")){
			//tagName="%,"+tagName+",%";
			tagName="%"+tagName+"%";
		}
    	List<Favorite> list=s.selectList("com.zd.mapper.FavoriteMapper.selectFavoriteOne",tagName);
    	s.commit();//为了二级缓存
		return list;
	}

	@Override
	public List<Favorite> findFavoriteAll() throws Exception {
		SqlSession s=MyBatisHelper.getSession();
    	List<Favorite> list=s.selectList("com.zd.mapper.FavoriteMapper.selectFavoriteAll");
    	s.commit();//为了二级缓存
		return list;
	}

}
