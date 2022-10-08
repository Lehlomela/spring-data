package com.hloms.spring.data.service;

import com.hloms.spring.data.common.UtilsGeneral;
import com.hloms.spring.data.domain.Customer;
import com.hloms.spring.data.repository.StreamableRepository;
import org.springframework.stereotype.Component;

import static com.hloms.spring.data.common.UtilsGeneral.log;

/*
 * Using Java Streams
 * https://reflectoring.io/comprehensive-guide-to-java-streams/
 */
@Component
public class MyStreamable {

  private StreamableRepository streamableRepository;

  public MyStreamable(final StreamableRepository streamableRepository) {
    this.streamableRepository = streamableRepository;
  }

  public void stream() {
// todo:: more code ?
    log.info("Using Filter");
    log.info("------------------------------------------------");
    streamableRepository.findByOrderByAgeAsc()
        .filter(customer -> "Bauer".equals(customer.getLastName()))
        .forEach(UtilsGeneral::logObject);
    log.info("");

    log.info("Using Map");
    log.info("------------------------------------------------");
    streamableRepository.findByOrderByAgeAsc().map(Customer::getFirstName)
        .forEach(UtilsGeneral::logObject);
    log.info("");

    log.info("Concatenate streamable Objects");
    log.info("------------------------------------------------");
    streamableRepository.findByOrderByAgeAsc()
        .and(streamableRepository.findByLastNameOrderByFirstNameDesc("Palmet"))
        .forEach(UtilsGeneral::logObject);// duplicates
    log.info("");
  }


}
