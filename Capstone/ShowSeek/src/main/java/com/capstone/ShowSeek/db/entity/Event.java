package com.capstone.ShowSeek.db.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "event")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "venue")
	private String venue;

	@Column(name = "zip")
	private Integer zip;

	@Column(name = "date")
	private java.sql.Date date;

	@Column(name = "time")
	private Integer time;

	@Column(name = "ticket_price")
	private java.math.BigDecimal ticket_price;

	@Column(name = "artist")
	private String artist;
	
	@Column(name = "image")
	private String image;

	// one event can have many ticket purchases
	@ToString.Exclude
	@OneToMany(mappedBy = "event")
	private List<Ticket_Purchase> eventTicketPurchases;

}