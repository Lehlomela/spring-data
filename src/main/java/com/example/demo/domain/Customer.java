package com.example.demo.domain;

import org.springframework.data.annotation.PersistenceCreator;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Customer {

  @GeneratedValue(strategy = GenerationType.AUTO)
  private @Id
  Long id;

  private String firstName;

  private String lastName;

  private int age;

  protected Customer() {
  }

  public Customer(String firstName, String lastName, int age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Customer customer = (Customer) o;
    return id.equals(customer.id) && firstName.equals(customer);
  }

  @Override
  public String toString() {
    return String.format(
        "Customer[id=%d, firstName='%s', lastName='%s' age='%d']",
        id, firstName, lastName, age);
  }

}