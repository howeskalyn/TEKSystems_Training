/*
 * ShowSeek - Form
 * for adding a ticket_puchase to the database.
 */

package com.capstone.ShowSeek.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateTicketPurchaseForm {
	
	private Integer user_id;
	
	private Integer event_id;
	
	private Integer quantity;

}
