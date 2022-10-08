package com.hloms.spring.data.repository;

import com.hloms.spring.data.domain.Customer;
import org.springframework.data.util.Streamable;

/*
 * YOU CAN USE Streamable AS ALTERNATIVE TO Iterable or any Collection type;
 * it provides convenience methods to access a non-parallel Stream (missing from Iterable)
 * Can:
 * 1) .filter(...)
 * 2) .map(...)
 * 3) concatenate Streamable to others
 */
public interface StreamableRepository extends MyBaseRepository {

  Streamable<Customer> findByOrderByAgeAsc();

  Streamable<Customer> findByLastNameOrderByFirstNameDesc(String lastName);

  /*
   * Returning Custom Streamable Wrapper Types
   * https://docs.spring.io/spring-data/commons/docs/current/reference/html/#repositories.collections-and-iterables.streamable-wrapper
   */
}
