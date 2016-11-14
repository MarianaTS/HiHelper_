package ua.com.hihelper.service;

import java.util.Set;

import ua.com.hihelper.entity.Location;

public interface LocationService {

	void save(Location location);
	void delete(int id);
	Location findOne(int id);
	Set<Location> findAll();
}
