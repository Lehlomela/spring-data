package com.hloms.spring.data;

import com.hloms.spring.data.repository.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class MyStreamable {

  private CustomerRepository customerRepository;

  public MyStreamable(final CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }


}
