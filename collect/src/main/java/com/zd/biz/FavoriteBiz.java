package com.zd.biz;

import java.util.List;

import com.zd.bean.Favorite;

public interface FavoriteBiz {
	public boolean addFavorite(Favorite fav)throws Exception;
	public List<Favorite> findFavoriteByTagName(String tagName)throws Exception;
	public List<Favorite> findFavoriteAll() throws Exception;
	
	
}
