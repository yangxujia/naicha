package com.naicha.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.naicha.app.mode.FriendCircle;

public interface FriendCircleDao extends Repository<FriendCircle, Integer> {

	/**
	 * 朋友圈保存
	 * @author yangxujia
	 * @date 2015年9月12日下午4:34:47
	 */
	public FriendCircle save(FriendCircle friendCircle);

	/**
	 * 
	 * @author yangxujia
	 * @date 2015年9月15日下午6:24:40
	 */
	@Query(nativeQuery=true,value="")
	public List<FriendCircle> findNearbyOrderByDistance(String geohashCode);

}