package com.example.demo;

import com.example.demo.domain.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import static com.example.demo.common.UtilsGeneral.log;
import static com.example.demo.common.UtilsGeneral.logInfo;

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
    logInfo("Customers found with findAll():");
    for (Customer customer : repository.findAll()) {
      // does not work with read/get/search
      log.info(customer.toString());
    }

    log.info("");
  }

  public void readGetQuerySearchStream() {
    // fetch customers by last name
    logInfo("Customer found with getByLastName('Bauer'):");
    repository.getByLastName("Bauer").forEach(bauer -> {
      log.info(bauer.toString());
    });
    log.info("");

    logInfo("Customers found with readByLastName:");
    repository.readByLastName("Bauer").forEach(bauer -> {
      log.info(bauer.toString());
    });
    log.info("");

    logInfo("Customers found with queryByLastName:");
    repository.queryByLastName("Bauer").forEach(bauer -> {
      log.info(bauer.toString());
    });
    log.info("");

    logInfo("Customers found with searchByLastName:");
    repository.searchByLastName("Bauer").forEach(bauer -> {
      log.info(bauer.toString());
    });
    log.info("");

    logInfo("Customers found with streamByLastName:");
    repository.streamByLastName("Bauer").forEach(bauer -> {
      log.info(bauer.toString());
    });
    log.info("");

  }

  public void getById() {
    // fetch an individual customer by ID
    Customer customer = repository.findById(1L);
    logInfo("Customer found with findById(1L):");
    log.info(customer.toString());
    log.info("");
  }

  public void countBy() {
    logInfo("Checking the number of customer with countByLastName('Bauer'):");
    log.info("Exists: " + repository.countByLastName("Bauer"));
    log.info("");

  }

  /*
   * LIMITING QUERY  RESULTS
   */
  public void topAndFirst() {
    logInfo("Customer found with findTopByLastName('Bauer'):");
    repository.findTopByLastName("Bauer").forEach(bauer -> {
      log.info(bauer.toString());
    });
    log.info("");

    logInfo("Customer found with findTopByOrderByAgeDesc():");
    repository.findTop2ByOrderByAgeDesc().forEach(p -> {
      log.info(p.toString());
    });
    log.info("");

    logInfo("Customer found with findFirst2ByLastName:");
    repository.findFirst2ByLastName("Bauer").forEach(bauer -> {
      // findFirst also works
      log.info(bauer.toString());
    });
    log.info("");
  }

  public void existsBy() {
    logInfo("Checking if customer exists with getByLastName('Bauer'):");
    log.info("Exists: " + repository.existsByLastName("Bauer"));
    log.info("");

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
