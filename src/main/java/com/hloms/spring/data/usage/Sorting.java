package com.hloms.spring.data.usage;

import com.hloms.spring.data.domain.Customer;
import com.hloms.spring.data.repository.CustomerRepositoryPagingAndSorting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.TypedSort;
import org.springframework.stereotype.Component;

@Component
public class Sorting {

  public static final Logger log = LoggerFactory.getLogger(Sorting.class);

  private final CustomerRepositoryPagingAndSorting pagingAndSorting;

  public Sorting(final CustomerRepositoryPagingAndSorting pagingAndSorting) {
    this.pagingAndSorting = pagingAndSorting;
  }


  public void sorting() {

    Sort sort = Sort.by("age").ascending();

    log.info("--------------------------------------------");
    log.info("Sort by age ascending");
    pagingAndSorting.findAll(sort).forEach(bauer -> {
      log.info("bauer = " + bauer);
    });

  }

  public void typeSafeApiSorting() {
    TypedSort<Customer> customer = Sort.sort(Customer.class);

    Sort sort = customer.by(Customer::getFirstName).ascending()
        /*
         * play ascending and descending to see what `and` is doing.
         * easy to see with larger sets of data
         */
        .and(customer.by(Customer::getAge).descending());

    pagingAndSorting.findAll(sort).forEach(bauer -> {
      log.info("bauer = " + bauer);
    });
  }


}
