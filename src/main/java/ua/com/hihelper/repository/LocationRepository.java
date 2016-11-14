package ua.com.hihelper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.hihelper.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
