/*
 * ShowSeek - DAO
 * Ticket_Purchase table usage.
 */

package com.capstone.ShowSeek.db.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.ShowSeek.db.entity.Ticket_Purchase;
import com.capstone.ShowSeek.db.entity.Event;

@Repository
public interface Ticket_PurchaseDAO extends JpaRepository<Ticket_Purchase, Long> {

	@Query("select t from Ticket_Purchase t where t.event_id = :eventID")
	public List<Ticket_Purchase> findByEventId(Integer eventID);

	// return event from ticket purchase table
	@Query("select e from Event e where e.id = :eventID")
	public Event findEventByEventId(Integer eventID);

	// return from user_id
	@Query("select t from Ticket_Purchase t where t.id = :userID")
	public List<Ticket_Purchase> findByUserId(Integer userID);

}
