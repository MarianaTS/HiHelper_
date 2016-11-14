package ua.com.hihelper.serviceimpl;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ua.com.hihelper.entity.Role;
import ua.com.hihelper.entity.User;
import ua.com.hihelper.repository.UserRepository;
import ua.com.hihelper.service.UserService;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		user.setRole(Role.ROLE_USER);
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		userRepository.delete(id);

	}

	@Override
	public User findOne(int id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return (List<User>) userRepository.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findUserByUsername(username);
	}

	@Override
	public User findFetchUser(int id) {
		// TODO Auto-generated method stub
		return userRepository.findFetchUser(id);
	}

	@Override
	public void saveImg(Principal principal, MultipartFile multipartFile) {

		User user = userRepository.findFetchUser(Integer.parseInt(principal.getName()));

		String path = "resources\\" + user.getOriginUsername() + "\\" + multipartFile.getOriginalFilename();

		user.setPathImage("resources/" + user.getOriginUsername() + "/" + multipartFile.getOriginalFilename());

		File file = new File(path);
		System.out.println(path);

		try {
			file.mkdirs();

			try {
				FileUtils.cleanDirectory(new File("resources\\" + user.getOriginUsername() + "\\"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				FileUtils.cleanDirectory(new File("resources\\" + user.getOriginUsername() + "\\"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			multipartFile.transferTo(file);
		} catch (IOException e) {
			System.out.println("error with file");
		}
		userRepository.save(user);
	}

}
