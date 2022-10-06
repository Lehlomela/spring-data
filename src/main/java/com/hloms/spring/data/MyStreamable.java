package com.example.demo;

import com.example.demo.repository.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class MyStreamable {

  private CustomerRepository customerRepository;

  public MyStreamable(final CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }


}
