package ua.com.hihelper.service;

import java.security.Principal;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ua.com.hihelper.entity.User;
import ua.com.hihelper.entity.Work;

public interface UserService {

	void save(User user);

	void delete(int id);

	User findOne(int id);

	List<User> findAll();

	User findFetchUser(int id);

	void saveImg(Principal principal, MultipartFile multipartfile);

	
	public void update(User user);

}
