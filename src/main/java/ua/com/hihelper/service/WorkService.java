package ua.com.hihelper.service;

import java.security.Principal;
import java.util.List;

import ua.com.hihelper.entity.Work;

public interface WorkService {

	void save(Work work);

	void delete(int id);

	Work findOne(int id);

	List<Work> findAll();

	void addwork(Principal principal, Work work);

	void like(Principal principal, Work work);
}
