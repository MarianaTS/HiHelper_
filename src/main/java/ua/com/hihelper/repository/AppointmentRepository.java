package ua.com.hihelper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.hihelper.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
