package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

  private final Sorting sorting;

  private final BasicQueryMethods bqm;

  private final Paging paging;

  public DemoApplication(final Sorting sorting, final BasicQueryMethods bqm, final Paging paging) {
    this.sorting = sorting;
    this.bqm = bqm;
    this.paging = paging;
  }

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Bean
  public CommandLineRunner demo() {
    return (args) -> {

//      saveCustomers();
//      pagingAndSorting.typeSafeApiSorting();
//      pagingAndSorting.sorting();
    };
  }

}
