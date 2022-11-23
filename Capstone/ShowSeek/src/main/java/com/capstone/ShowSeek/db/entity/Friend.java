package com.capstone.ShowSeek.db.entity;

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
@Table(name = "friend")
public class Friend {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "user_id")
	private Integer user_id;
	
	@Column(name = "friend_id")
	private Integer friend_id;
	
	// there are many friends to one user
	@ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="id", insertable=false, updatable=false) // in User table
    private User user;

}
