package com.song.woo.repo;
 
import java.util.List;
 
import org.springframework.data.repository.CrudRepository;

import com.song.woo.model.Customer;


 

//dao의 역할을 함
public interface CustomerRepository extends CrudRepository<Customer, Integer>{//테이블, 아이
//	List<Customer> findByLastName(String lastName);
}

