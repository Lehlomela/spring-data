package com.hloms.spring.data;

import com.hloms.spring.data.domain.Customer;
import com.hloms.spring.data.repository.CustomerRepository;
import com.hloms.spring.data.common.UtilsGeneral;
import org.springframework.stereotype.Component;

@Component
public class BasicQueryMethods {

  private final CustomerRepository repository;

  public BasicQueryMethods(final CustomerRepository repository) {
    this.repository = repository;
  }

  public void saveCustomers() {
//    save a few customers
    repository.save(new Customer("Jack", "Bauer", 20));
    repository.save(new Customer("Mpho", "Bauer", 27));
    repository.save(new Customer("Chloe", "O'Brian", 31));
    repository.save(new Customer("Kim", "Bauer", 90));
    repository.save(new Customer("Thabo", "Bauer", 81));
    repository.save(new Customer("David", "Palmer", 60));
    repository.save(new Customer("David", "Palmet", 67));
    repository.save(new Customer("Michelle", "Dessler", 50));
  }

  public void fetchAllCustomers() {
    // fetch all customers
    UtilsGeneral.logInfo("Customers found with findAll():");
    for (Customer customer : repository.findAll()) {
      // does not work with read/get/search
      UtilsGeneral.log.info(customer.toString());
    }

    UtilsGeneral.log.info("");
  }

  public void readGetQuerySearchStream() {
    // fetch customers by last name
    UtilsGeneral.logInfo("Customer found with getByLastName('Bauer'):");
    repository.getByLastName("Bauer").forEach(bauer -> {
      UtilsGeneral.log.info(bauer.toString());
    });
    UtilsGeneral.log.info("");

    UtilsGeneral.logInfo("Customers found with readByLastName:");
    repository.readByLastName("Bauer").forEach(bauer -> {
      UtilsGeneral.log.info(bauer.toString());
    });
    UtilsGeneral.log.info("");

    UtilsGeneral.logInfo("Customers found with queryByLastName:");
    repository.queryByLastName("Bauer").forEach(bauer -> {
      UtilsGeneral.log.info(bauer.toString());
    });
    UtilsGeneral.log.info("");

    UtilsGeneral.logInfo("Customers found with searchByLastName:");
    repository.searchByLastName("Bauer").forEach(bauer -> {
      UtilsGeneral.log.info(bauer.toString());
    });
    UtilsGeneral.log.info("");

    UtilsGeneral.logInfo("Customers found with streamByLastName:");
    repository.streamByLastName("Bauer").forEach(bauer -> {
      UtilsGeneral.log.info(bauer.toString());
    });
    UtilsGeneral.log.info("");

  }

  public void getById() {
    // fetch an individual customer by ID
    Customer customer = repository.findById(1L);
    UtilsGeneral.logInfo("Customer found with findById(1L):");
    UtilsGeneral.log.info(customer.toString());
    UtilsGeneral.log.info("");
  }

  public void countBy() {
    UtilsGeneral.logInfo("Checking the number of customer with countByLastName('Bauer'):");
    UtilsGeneral.log.info("Exists: " + repository.countByLastName("Bauer"));
    UtilsGeneral.log.info("");

  }

  /*
   * LIMITING QUERY  RESULTS
   */
  public void topAndFirst() {
    UtilsGeneral.logInfo("Customer found with findTopByLastName('Bauer'):");
    repository.findTopByLastName("Bauer").forEach(bauer -> {
      UtilsGeneral.log.info(bauer.toString());
    });
    UtilsGeneral.log.info("");

    UtilsGeneral.logInfo("Customer found with findTopByOrderByAgeDesc():");
    repository.findTop2ByOrderByAgeDesc().forEach(p -> {
      UtilsGeneral.log.info(p.toString());
    });
    UtilsGeneral.log.info("");

    UtilsGeneral.logInfo("Customer found with findFirst2ByLastName:");
    repository.findFirst2ByLastName("Bauer").forEach(bauer -> {
      // findFirst also works
      UtilsGeneral.log.info(bauer.toString());
    });
    UtilsGeneral.log.info("");
  }

  public void existsBy() {
    UtilsGeneral.logInfo("Checking if customer exists with getByLastName('Bauer'):");
    UtilsGeneral.log.info("Exists: " + repository.existsByLastName("Bauer"));
    UtilsGeneral.log.info("");

  }

  public void findDistinct() {
    // todo
  }

  /*
   * QUERY METHODS THAT RETURN MULTIPLE RESULTS
   * Use:
   * Standard Java: Iterable, List, Set
   * Spring Data's: Streamable (custom extension Iterable)
   * Collection types provided by [Vavr](https://www.vavr.io/)
   *
   */

}
