package com.capstone.ShowSeek.db.entity;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ticket_purchase")
public class Ticket_Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "event_id")
	private Integer event_id;
	
	@Column(name = "user_id")
	private Integer user_id;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	// each ticket purchase is linked to a single user
	@ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="id", insertable=false, updatable=false) // in User table
    private User user;
	
	// each ticket purchase is linked to a single event
	@ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="id", insertable=false, updatable=false) // in Event table
    private Event event;
}
