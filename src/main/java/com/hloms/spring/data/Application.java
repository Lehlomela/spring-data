package com.hloms.spring.data;

import com.hloms.spring.data.service.PredicateKeywordsAndModifiers;
import com.hloms.spring.data.service.MyStreamable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

  private final Sorting sorting;

  private final BasicQueryMethods bqm;

  private final Paging paging;

  private final MyStreamable myStreamable;

  private final PredicateKeywordsAndModifiers predicateKeyAndMod;

  public Application(final Sorting sorting, final BasicQueryMethods bqm, final Paging paging,
                     final MyStreamable myStreamable, final PredicateKeywordsAndModifiers predicateKeyAndMod) {
    this.sorting = sorting;
    this.bqm = bqm;
    this.paging = paging;
    this.myStreamable = myStreamable;
    this.predicateKeyAndMod = predicateKeyAndMod;
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public CommandLineRunner demo() {
    return (args) -> {

//      bqm.saveCustomers();
//        bqm.topAndFirst();
//        bqm.readGetQuerySearchStream();
//      pagingAndSorting.typeSafeApiSorting();
//      pagingAndSorting.sorting();
//      predicateKeyAndMod.usingPredicateKeywordsAndModifiers();

      myStreamable.stream();

    };
  }

}
