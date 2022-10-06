package com.example.demo.domain;

import org.hibernate.annotations.ColumnDefault;

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

  @ColumnDefault("True")
  private boolean active;

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

  public int getAge() {
    return age;
  }

  public String getLastName() {
    return lastName;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(final boolean active) {
    this.active = active;
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
    return id.equals(customer.id) && firstName.equals(customer.firstName);
  }

  @Override
  public String toString() {
    return String.format(
        "Customer[id=%d, firstName='%s', lastName='%s' age='%d']",
        id, firstName, lastName, age);
  }

}