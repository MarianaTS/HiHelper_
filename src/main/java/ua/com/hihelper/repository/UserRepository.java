package ua.com.hihelper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import ua.com.hihelper.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	UserDetails findUserByUsername(String username);

	@Query(value = "select u from User u left join fetch u.works where u.id=:id")
	User findFetchUser(@Param("id") int id);

}
