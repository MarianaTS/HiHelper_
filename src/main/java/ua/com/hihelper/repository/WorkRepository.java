package ua.com.hihelper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.hihelper.entity.Work;

public interface WorkRepository extends JpaRepository<Work, Integer> {

	@Query("select w from Work w left join fetch w.likes l where w.id =:id")
	Work workwithusers(@Param("id") int id);

}
