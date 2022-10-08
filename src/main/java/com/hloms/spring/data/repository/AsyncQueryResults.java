package com.hloms.spring.data.repository;

import com.hloms.spring.data.domain.Customer;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/*
 * "You can run repository queries asynchronously by using Spring’s asynchronous method running
 * capability. This means the method returns immediately upon invocation while the actual query
 * occurs in a task that has been submitted to a Spring TaskExecutor. Asynchronous queries differ
 * from reactive queries and should not be mixed. See the store-specific documentation for more
 * details on reactive support. The following example shows a number of asynchronous queries"
 *
 *
 */
public interface AsyncQueryResults extends MyBaseRepository {

  // todo:: write more code on this
  /*
   * Use java.util.concurrent.Future, java.util.concurrent.CompletableFuture,
   * org.springframework.util.concurrent.ListenableFuture as the return type.
   */
  @Async
  Future<Customer> findByFirstname(String firstname);

  @Async
  CompletableFuture<Customer> findOneByFirstname(String firstname);

  @Async
  ListenableFuture<Customer> findOneByLastname(String lastname);

}
