package com.example.demo;

import com.example.demo.domain.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.CustomerRepositoryPagingAndSorting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Pageable;

@SpringBootApplication
public class DemoApplication {

  private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

  private CustomerRepository repository;

  private CustomerRepositoryPagingAndSorting pagingAndSorting;

  public DemoApplication(final CustomerRepository repository,
                         CustomerRepositoryPagingAndSorting pagingAndSorting) {
    this.repository = repository;
    this.pagingAndSorting = pagingAndSorting;
  }

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Bean
  public CommandLineRunner demo() {
    return (args) -> {

      log.info("Customer found with findTopByLastName('Bauer'):");
      log.info("--------------------------------------------");
//      repository.findByLastNameAgeLessThan50("Bauer").forEach(bauer -> {
//        log.info(bauer.toString());
//      });
      log.info("");

    };
  }

  private void workingWithPage() {
    pagingAndSorting.findByLastName("Bauer", Pageable.ofSize(3));
  }

  private void topAndFirst() {
    log.info("Customer found with findTopByLastName('Bauer'):");
    log.info("--------------------------------------------");
    repository.findTopByLastName("Bauer").forEach(bauer -> {
      log.info(bauer.toString());
    });
    log.info("");

    log.info("Customer found with findFirst2ByLastName:");
    log.info("-------------------------------");
    repository.findFirst2ByLastName("Bauer").forEach(bauer -> {
      // findFirst also works
      log.info(bauer.toString());
    });
    log.info("");
  }

  private void getById() {
    // fetch an individual customer by ID
    Customer customer = repository.findById(1L);
    log.info("Customer found with findById(1L):");
    log.info("--------------------------------");
    log.info(customer.toString());
    log.info("");
  }

  private void fetchAllCustomers() {
    // fetch all customers
    log.info("Customers found with findAll():");
    log.info("-------------------------------");
    for (Customer customer : repository.findAll()) {
      // does not work with read/get/search
      log.info(customer.toString());
    }

    log.info("");
  }

  private void saveCustomers() {
//    save a few customers
    repository.save(new Customer("Jack", "Bauer", 20));
    repository.save(new Customer("Chloe", "O'Brian", 31));
    repository.save(new Customer("Kim", "Bauer", 90));
    repository.save(new Customer("David", "Palmer", 60));
    repository.save(new Customer("Michelle", "Dessler", 50));
  }

  private void existsBy() {
    log.info("Checking if customer exists with getByLastName('Bauer'):");
    log.info("--------------------------------------------");
    log.info("Exists: " + repository.existsByLastName("Bauer"));
    log.info("");

  }

  private void countBy() {
    log.info("Checking the number of customer with countByLastName('Bauer'):");
    log.info("--------------------------------------------");
    log.info("Exists: " + repository.countByLastName("Bauer"));
    log.info("");

  }

  private void readGetQuerySearch() {
    // fetch customers by last name
    log.info("Customer found with getByLastName('Bauer'):");
    log.info("--------------------------------------------");
    repository.getByLastName("Bauer").forEach(bauer -> {
      log.info(bauer.toString());
    });
    log.info("");

    log.info("Customers found with readByLastName:");
    log.info("-------------------------------");
    repository.readByLastName("Bauer").forEach(bauer -> {
      log.info(bauer.toString());
    });
    log.info("");

    log.info("Customers found with queryByLastName:");
    log.info("-------------------------------");
    repository.queryByLastName("Bauer").forEach(bauer -> {
      log.info(bauer.toString());
    });
    log.info("");

    log.info("Customers found with searchByLastName:");
    log.info("-------------------------------");
    repository.searchByLastName("Bauer").forEach(bauer -> {
      log.info(bauer.toString());
    });
    log.info("");
  }

  private void findDistinct() {
    // todo
  }

}
