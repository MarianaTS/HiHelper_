package ua.com.hihelper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.hihelper.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

	@Query(value = "select s from Schedule s left join fetch Work w where w.id =:id")
	List<Schedule> findScheduleByWorks(@Param("id") int id);

}
