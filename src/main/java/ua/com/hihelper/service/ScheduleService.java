package ua.com.hihelper.service;

import java.util.List;

import ua.com.hihelper.entity.Schedule;

public interface ScheduleService {

	void save(Schedule schedule);

	void delete(int id);

	Schedule findOne(int id);

	List<Schedule> findAll();
}
