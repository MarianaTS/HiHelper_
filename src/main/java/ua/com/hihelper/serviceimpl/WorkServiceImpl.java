package ua.com.hihelper.serviceimpl;

import java.security.Principal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import ua.com.hihelper.entity.Schedule;
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

	@Modifying
	@Transactional
	@Override
	public void like(Principal principal, int id) {
		User user = userservice.findFetchUser(Integer.parseInt(principal.getName()));
		Work work = workRepository.workwithusers(id);

		System.out.println(work.getLikes());

		if (work.getLikes().contains(user)) {
			work.getLikes().remove(user);
			work.setCount(work.getLikes().size());
			save(work);
		}

		else {

			work.getLikes().add(user);
			work.setCount(work.getLikes().size());
			save(work);
		}
		System.out.println(work.getLikes());

	}

	@Modifying
	@Transactional
	@Override
	public void addSchedule(Work work, Schedule schedule) {

		work.getSchedule().add(schedule);
		save(work);

	}

}
