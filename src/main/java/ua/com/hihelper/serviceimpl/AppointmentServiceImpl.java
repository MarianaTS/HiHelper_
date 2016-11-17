package ua.com.hihelper.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import ua.com.hihelper.entity.Appointment;
import ua.com.hihelper.entity.User;
import ua.com.hihelper.entity.Work;
import ua.com.hihelper.repository.AppointmentRepository;
import ua.com.hihelper.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository ar;

	@Override
	public void save(Appointment appointment) {
		// TODO Auto-generated method stub
		ar.save(appointment);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		ar.delete(id);
	}

	@Override
	public Appointment findOne(int id) {
		// TODO Auto-generated method stub
		return ar.findOne(id);
	}

	@Override
	public List<Appointment> findAll() {
		// TODO Auto-generated method stub
		return ar.findAll();
	}

	@Modifying
	@Transactional
	@Override
	public void sendmessage(Work work, User sender, String text) {
		Appointment ap = new Appointment();
		ap.setWork(work);
		ap.setSender(sender);
		ap.setMessagetext(text);
		ar.save(ap);

	}

}
