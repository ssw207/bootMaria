package com.song.woo.model;
 
import java.io.Serializable;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "customer")
public class Customer implements Serializable {
 
	private static final long serialVersionUID = -3009157732242241606L;
	//해당칼럼이 식별키임을 지칭
	@Id
	//시퀀스와 동일한일을함
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
 
	@Column(name = "firstname")
	private String firstName;
 
	@Column(name = "lastname")
	private String lastName;
 
	
	
	protected Customer() {
	}
 
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
 
	@Override
	public String toString() {
		return String.format("Customer[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
	}
}
