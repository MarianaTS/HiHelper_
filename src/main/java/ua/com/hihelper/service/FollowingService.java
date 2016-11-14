package ua.com.hihelper.service;

import java.util.Set;

import ua.com.hihelper.entity.Following;

public interface FollowingService {
	
	void save(Following following);
	void delete(int id);
	Following findOne(int id);
	Set<Following> findAll();

}
