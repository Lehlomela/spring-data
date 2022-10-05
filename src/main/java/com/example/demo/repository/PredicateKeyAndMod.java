package com.example.demo.repository;

import com.example.demo.domain.Customer;
import org.springframework.data.repository.Repository;

import java.util.List;

/*
 * Using predicate Keywords and Modifiers
 * consult the store-specific documentation for the exact list of supported keywords,
 * because some keywords listed here might not be supported in a particular store.
 *
 * postgres sql keywords: https://www.postgresql.org/docs/current/sql-keywords-appendix.html
 *
 * SELECTIVELY EXPOSE CRUD METHODS BY EXTENDING Repository
 */
public interface CustomerRepositoryPredicateKeyAndMod extends Repository<Customer, Long> {

  /*
   * Logical Keyword: KeywordExpression
   * AND: And
   */
  List<Customer> findByFirstNameAndLastName(String firstName, String lastName);

  /*
   * AND
   */
  /*
   * AND
   */
  /*
   * AND
   */
  /*
   * AND
   */
  /*
   * AND
   */
  /*
   * AND
   */
  /*
   * AND
   */
  /*
   * AND
   */
  /*
   * AND
   */
}
