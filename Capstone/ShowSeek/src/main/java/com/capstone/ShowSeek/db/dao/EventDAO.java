package com.capstone.ShowSeek.db.dao;

import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.ShowSeek.db.entity.Event;

@Repository
public interface EventDAO extends JpaRepository<Event, Long> {

	@Query("select e from Event e where e.venue like %:venue%")
	public List<Event> findByVenue(String venue);

	@Query(value = "select artist, count(*) as cnt from event where artist is not null and artist != \"\" group by artist order by artist", nativeQuery = true)
	public List<Map<String, Object>> artistEventCount();
	
	// return events from user email
	@Query(value="select * from event e join ticket_purchase tp on e.id = tp.event_id join user u on u.id = tp.user_id where u.email = :email order by e.date", nativeQuery = true)
	public List<Event> findEventByUserEmail(String email);
	
	@Query(value = "select * from event order by date asc", nativeQuery = true)
	public List<Event> findEventsOrderByDate();
	
	@Query(value = "select * from event order by artist asc", nativeQuery = true)
	public List<Event> findEventsOrderByArtist();
	
	@Query(value = "select * from event order by ticket_price asc", nativeQuery = true)
	public List<Event> findEventsOrderByPrice();
	
	@Query(value = "select * from event order by venue asc", nativeQuery = true)
	public List<Event> findEventsOrderByVenue();
	
}
