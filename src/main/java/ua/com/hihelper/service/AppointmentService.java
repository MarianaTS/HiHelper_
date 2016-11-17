package ua.com.hihelper.service;

import java.util.List;

import ua.com.hihelper.entity.Appointment;
import ua.com.hihelper.entity.User;
import ua.com.hihelper.entity.Work;

public interface AppointmentService {

	void save(Appointment appointment);

	void delete(int id);

	Appointment findOne(int id);

	List<Appointment> findAll();

	void sendmessage(Work work, User sender, String text);
}
