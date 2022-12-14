# Spring Data

## Working with spring data repositories

### Core Concepts

`Repository`:  Central Interface.
<br>

`CrudRepository`: extends `Repository` and provides more CRUD functionality.
<br>

`PagingAndSortingRepository`: adds additional methods to ease paginated access to entities.

```java
 // example

    PagingAndSortingRepository<User, Long> repository=;// … get access to a bean
    Page<User> users=repository.findAll(PageRequest.of(1,20));
```

Typically your interface extends `Repository`, `CrudRepository`, or `PagingAndSortingRepository`

### Defining Repository Interfaces

#### [Using Repositories with multiple spring data modules][MSDM]

[MSDM]: https://docs.spring.io/spring-data/commons/docs/current/reference/html/#repositories.multiple-modules

### Defining Query Methods

```java
interface PersonRepository extends Repository<Person, Long> {

  List<Person> findByEmailAddressAndLastname(EmailAddress emailAddress, String lastname);

  // Enables the distinct flag for the query
  List<Person> findDistinctPeopleByLastnameOrFirstname(String lastname, String firstname);

  List<Person> findPeopleDistinctByLastnameOrFirstname(String lastname, String firstname);

  // Enabling ignoring case for an individual property
  List<Person> findByLastnameIgnoreCase(String lastname);

  // Enabling ignoring case for all suitable properties
  List<Person> findByLastnameAndFirstnameAllIgnoreCase(String lastname, String firstname);

  // Enabling static ORDER BY for a query
  List<Person> findByLastnameOrderByFirstnameAsc(String lastname);

  List<Person> findByLastnameOrderByFirstnameDesc(String lastname);

}
```

[Supported query method subject keywords][SKey] (before the first `by`) <br>
[Query method Predicate keywords][PreKey]:  
[How to name your repo interface methods][repoIntr]


[SKey]: https://docs.spring.io/spring-data/commons/docs/current/reference/html/#appendix.query.method.subject

[PreKey]: https://docs.spring.io/spring-data/commons/docs/current/reference/html/#appendix.query.method.predicate

[repoIntr]: https://docs.spring.io/spring-data/commons/docs/current/reference/html/#repositories.query-methods.query-property-expressions

#### Special Parameter Handling

```java
    Page<User> findByLastname(String lastname,Pageable pageable);

    Slice<User> findByLastname(String lastname,Pageable pageable);

    List<User> findByLastname(String lastname,Sort sort);

    List<User> findByLastname(String lastname,Pageable pageable);
```

> If you do not want to apply any sorting or pagination, use `Sort.unsorted()` and `Pageable.unpaged()`.

---

## [Supported Query Return Types][SQRT]

[SQRT]: https://docs.spring.io/spring-data/commons/docs/current/reference/html/#appendix.query.return.types

--- 

## Annotations

`@RepositoryDefinition`: use if you do not want to extend Spring Data interfaces.
<br>
`@NoRepositoryBean`: repository interfaces for which Spring Data should not create instances at runtime.

### Nullability Annotations

`@NonNullApi`: Used on the package level to declare that the default behavior for parameters and return values is,
respectively, neither to accept nor to produce null values.

`@NonNull`: Used on a parameter or return value that must not be null (not needed on a parameter and return value where
@NonNullApi applies).

`@Nullable`: Used on a parameter or return value that can be null

```java
package com.acme;

import org.springframework.lang.Nullable;

interface UserRepository extends Repository<User, Long> {

  // Throws an EmptyResultDataAccessException when the query does not produce a result.
  // Throws an IllegalArgumentException when the emailAddress handed to the method is null.
  User getByEmailAddress(EmailAddress emailAddress);

  // Returns null when the query does not produce a result.
  // Also accepts null as the value for emailAddress.
  @Nullable
  User findByEmailAddress(@Nullable EmailAddress emailAdress);

  // 	Returns Optional.empty() when the query does not produce a result.
  // Throws an IllegalArgumentException when the emailAddress handed to the method is null.
  Optional<User> findOptionalByEmailAddress(EmailAddress emailAddress);

}

```

