package com.example.demo.repository;

import com.example.demo.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/*
 * todo::
 */
@NoRepositoryBean
public interface MyBaseRepository extends JpaRepository<Customer, Long> {

}
