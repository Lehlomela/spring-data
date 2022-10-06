package com.example.demo.repository;

import com.example.demo.domain.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

/*
 * If you do not want to apply any sorting or pagination, use `Sort.unsorted()` and
 * `Pageable.unpaged()`
 */
@RepositoryDefinition(domainClass = Customer.class, idClass = Long.class)
public interface CustomerRepositoryPagingAndSorting {

  /*
   *  A Page knows about the total number of elements and pages available
   *  It does so by the infrastructure triggering a count query to calculate the overall number.
   *  As this might be expensive (depending on the store used), you can instead return a Slice
   */
  Page<Customer> findByLastName(String LastName, Pageable pageable);

  /*
   * Knows only whether a next slice is available (Larger sets)
   */
  Slice<Customer> findAll(Pageable pageable);

  /*
   *
   */
  List<Customer> findByLastName(String lastname, Sort sort);

  List<Customer> findAll(Sort sort);

}
