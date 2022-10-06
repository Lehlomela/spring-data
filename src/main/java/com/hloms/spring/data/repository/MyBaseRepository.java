package com.hloms.spring.data.repository;

import com.hloms.spring.data.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/*
 * todo::
 */
@NoRepositoryBean
public interface MyBaseRepository extends JpaRepository<Customer, Long> {

}
