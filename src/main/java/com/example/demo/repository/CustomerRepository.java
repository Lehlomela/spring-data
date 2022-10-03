package com.example.demo.repository;

import com.example.demo.domain.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/*
 * 1) Declare interface extending repository or one of its sub-interfaces
 * 2) Define domain type and ID type it should handle
 * 3) Declare query methods on interface
 * 4) inject interface and use (DemoApplication.class)
 *
 * Extend Repository if you do not want to expose CRUD methods
 *
 * use @RepositoryDefinition if you do not want to extend Repository, CrudRepository,
 * or PagingAndSortingRepository
 */
//@RepositoryDefinition(domainClass = Customer.class, idClass = Long.class)
public interface CustomerRepository extends CrudRepository<Customer, Long> {

  /*
   * find..by and exists..by defines the subject of the query
   * Any text between find and by is considered to be descriptive
   * ...unless using one of the result-limiting keywords such as a Distinct
   * concatenate with `and` and `or`
   */
  List<Customer> findByLastName(String lastName);

  Customer findById(long id);

  /*
   * find…By, read…By, get…By, query…By, search…By, stream…By
   * (they seem to produce the same results)
   */
  List<Customer> readByLastName(String lastName);

  List<Customer> getByLastName(String lastName);

  List<Customer> queryByLastName(String lastName);

  List<Customer> searchByLastName(String lastName);

  List<Customer> streamByLastName(String lastName);

  /*
   * LIMITING QUERY RESULTS
   *
   * …First<number>…, …Top<number>…
   * between `find` (and the other keywords) and by
   * Can be used interchangeably
   */

  List<Customer> findFirst2ByLastName(String lastName);

  List<Customer> findTopByLastName(String lastName);

  List<Customer> findTop2ByOrderByAgeDesc();

  /*
   * exists…By
   */
  boolean existsByLastName(String lastName);

  /*
   * Distinct: between find and by
   * Database used has to support
   * todo: check more examples, still don't get it
   */

  /*
   * Count
   */
  int countByLastName(String lastName);

  /*
   *
   */
//  List<Customer> findByLastNameAgeLessThan50(String lastName);
}
