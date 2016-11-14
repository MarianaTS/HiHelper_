package ua.com.hihelper.serviceimpl;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import ua.com.hihelper.entity.User;
import ua.com.hihelper.entity.Work;
import ua.com.hihelper.repository.UserRepository;
import ua.com.hihelper.repository.WorkRepository;
import ua.com.hihelper.service.UserService;
import ua.com.hihelper.service.WorkService;

@Service
public class WorkServiceImpl implements WorkService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserService userservice;
	@Autowired
	private WorkRepository workRepository;

	@Override
	public void save(Work work) {

		workRepository.save(work);

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		workRepository.delete(id);
	}

	@Override
	public Work findOne(int id) {
		// TODO Auto-generated method stub
		return workRepository.findOne(id);
	}

	@Override
	public List<Work> findAll() {
		// TODO Auto-generated method stub
		return workRepository.findAll();
	}

	@Transactional
	@Modifying
	@Override
	public void addwork(Principal principal, Work work) {
		User user = userRepository.findFetchUser(Integer.parseInt(principal.getName()));

		workRepository.saveAndFlush(work);
		work.setUser(user);
		workRepository.save(work);

	}

	@Override
	public void like(Principal principal, Work work) {
		User user = userservice.findFetchUser(Integer.parseInt(principal.getName()));
		Set<User> likes = new HashSet<>();
		likes.addAll(work.getLikes());
		if (likes.contains(user)) {
			likes.remove(user);
			work.setCount(likes.size() - 1);
			save(work);
		} else {

			likes.add(userservice.findFetchUser(Integer.parseInt(principal.getName())));
			work.setLikes(likes);
			work.setCount(likes.size());
			save(work);
		}

	}

}
