package com.capstone.ShowSeek.db.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.ShowSeek.db.entity.Event;

@Repository
public interface EventDAO extends JpaRepository<Event, Long> {
	
	@Query("select e from Event e where e.venue like %:venue%")
	public List<Event> findByVenue(String venue);

}
