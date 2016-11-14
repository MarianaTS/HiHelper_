package ua.com.hihelper.serviceimpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import ua.com.hihelper.entity.Location;
import ua.com.hihelper.repository.LocationRepository;
import ua.com.hihelper.service.LocationService;

public class LocationServiceImpl implements LocationService {

	
	@Autowired
	private LocationRepository locationRepository;
	
	@Override
	public void save(Location location) {
		// TODO Auto-generated method stub

		locationRepository.save(location);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

		locationRepository.delete(id);
	}

	@Override
	public Location findOne(int id) {
		// TODO Auto-generated method stub
		return (Location) locationRepository.findOne(id);
	}

	@Override
	public Set<Location> findAll() {
		// TODO Auto-generated method stub
		return (Set)locationRepository.findAll();
	}

}
