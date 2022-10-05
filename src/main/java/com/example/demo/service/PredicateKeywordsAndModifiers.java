package com.example.demo.service;

import com.example.demo.repository.PredicateKeyAndMod;
import org.springframework.stereotype.Service;

import static com.example.demo.common.UtilsGeneral.log;
import static com.example.demo.common.UtilsGeneral.logInfo;

@Service
public class PredicateKeywordsAndModifiers {

  private final PredicateKeyAndMod predicateKeyAndMod;

  public PredicateKeywordsAndModifiers(final PredicateKeyAndMod predicateKeyAndMod) {
    this.predicateKeyAndMod = predicateKeyAndMod;
  }

  public void usingPredicateKeywordsAndModifiers() {
    logInfo("findByFirstNameAndLastName('Jack','Bauer')");
    predicateKeyAndMod.findByFirstNameAndLastName("Jack", "Bauer").forEach(jack -> {
      log.info(jack + "");
    });
    log.info("");

    logInfo("findByFirstNameOrLastName('Jack','Bauer')");
    predicateKeyAndMod.findByFirstNameOrLastName("Jack", "Bauer").forEach(customer -> {
      log.info(customer + "");
    });
    log.info("");

    logInfo("findByLastNameContains(\"a\")");
    predicateKeyAndMod.findByLastNameContains("a").forEach(customer -> {
      log.info(customer + "");
    });
    log.info("");


    logInfo("findByAgeBetween(10, 40)");
    predicateKeyAndMod.findByAgeBetween(10, 40).forEach(customer -> {
      log.info(customer + "");
    });
    log.info("");

    logInfo("findByFirstNameBetween(\"a\", \"f\")");
    predicateKeyAndMod.findByAgeAndFirstNameBetween(31, "a", "f").forEach(customer -> {
      log.info(customer + "");
    });
    log.info("");

    logInfo("findByLastNameEndingWith(\"r\")");
    predicateKeyAndMod.findByLastNameEndingWith("r").forEach(customer -> {
      log.info(customer + "");
    });
    log.info("");

    logInfo("findByLastNameEndingWith(\"r\")");
    predicateKeyAndMod.findByAgeGreaterThan(27).forEach(customer -> {
      log.info(customer + "");
    });
    log.info("");





  }


}
