package ua.com.hihelper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.hihelper.entity.Work;

public interface WorkRepository extends JpaRepository<Work, Integer> {

}
