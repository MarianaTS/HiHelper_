package ua.com.hihelper.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.hihelper.entity.Schedule;
import ua.com.hihelper.repository.ScheduleRepository;
import ua.com.hihelper.service.ScheduleService;

@Service
public class ScheduleServuceImpl implements ScheduleService {

	@Autowired
	private ScheduleRepository sr;

	@Override
	public void save(Schedule schedule) {
		// TODO Auto-generated method stub
		sr.save(schedule);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		sr.delete(id);
	}

	@Override
	public Schedule findOne(int id) {
		// TODO Auto-generated method stub
		return sr.findOne(id);
	}

	@Override
	public List<Schedule> findAll() {
		// TODO Auto-generated method stub
		return sr.findAll();
	}

}
