package ua.com.hihelper.serviceimpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import ua.com.hihelper.entity.Following;
import ua.com.hihelper.repository.FollowingRepository;
import ua.com.hihelper.service.FollowingService;

public class FollowingServiceImpl implements FollowingService {

	
	@Autowired
	FollowingRepository followingRepository;
	@Override
	public void save(Following following) {
	followingRepository.save(following);
		
	}

	@Override
	public void delete(int id) {
followingRepository.delete(id);		
	}

	@Override
	public Following findOne(int id) {
		// TODO Auto-generated method stub
		return followingRepository.findOne(id);
	}

	@Override
	public Set<Following> findAll() {
		// TODO Auto-generated method stub
		return (Set<Following>) followingRepository.findAll();
	}

}
