package com.example.demo.repository;

import com.example.demo.domain.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = Customer.class, idClass = Long.class)
public interface CustomerRepositoryPagingAndSorting {

  /*
   * If you do not want to apply any sorting or pagination, use `Sort.unsorted()` and
   * `Pageable.unpaged()`
   */

  Page<Customer> findByLastName(String LastName, Pageable pageable);

}
