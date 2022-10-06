package com.example.demo.repository;

import com.example.demo.domain.Customer;
import org.springframework.data.repository.Repository;

import java.util.List;

/*
 * Using predicate Keywords and Modifiers
 * consult the store-specific documentation for the exact list of supported keywords,
 * because some keywords listed here might not be supported in a particular store.
 *
 * postgres sql keywords: https://www.postgresql.org/docs/current/sql-keywords-appendix.html
 *
 * SELECTIVELY EXPOSE CRUD METHODS BY EXTENDING Repository
 */
public interface PredicateKeyAndMod extends Repository<Customer, Long> {

  /*==============================================================
   *                    QUERY PREDICATE KEYWORDS
   ===============================================================*/
  /*
   * Logical Keyword: KeywordExpression
   * AND: And
   */
  List<Customer> findByFirstNameAndLastName(String firstName, String lastName);

  /*
   * OR: or
   */
  List<Customer> findByFirstNameOrLastName(String firstName, String lastName);

  /*
   * AFTER: After, IsAfter
   */

  /*
   * BEFORE: Before, IsBefore
   */

  /*
   * CONTAINING: Containing, IsContaining, Contains
   * Searches for: A word or phrase.
   */
  List<Customer> findByLastNameContains(String word);

  /*
   * BETWEEN: Between, IsBetween
   */
  List<Customer> findByAgeBetween(int min, int max);

  List<Customer> findByAgeAndFirstNameBetween(int i, String start, String end);

  /*
   * ENDING_WITH: EndingWith, IsEndingWith, EndsWith
   */
  List<Customer> findByLastNameEndingWith(String value);

  List<Customer> findByAgeEndingWith(int value);//throws exception

  /*
   * EXISTS: Exists
   * Unsupported by postgresql ??
   */

  /*
   * GREATER_THAN: GreaterThan, IsGreaterThan
   */
  List<Customer> findByAgeGreaterThan(int minAge);

  List<Customer> findByFirstNameGreaterThan(String min);

  /*
   * GREATER_THAN_EQUALS: GreaterThanEqual, IsGreaterThanEqual
   */
  List<Customer> findByAgeGreaterThanEqual(int minAge);

  /*
   * LIKE: Like, IsLike
   */
  List<Customer> findByFirstNameLike(String value); // CASE SENSITIVE

  List<Customer> findByFirstNameLikeAllIgnoreCase(String value);

  List<Customer> findByFirstNameAndLastNameLikeAllIgnoreCase(String first, String last);

  /*
   * NOT_LIKE: NotLike, IsNotLike
   */
  List<Customer> findByFirstNameNotLike(String value);

  /*
   * NEAR: Near, IsNear
   */

  /*
   * NOT: Not, IsNot
   * CASE SENSITIVE
   * List of names ??
   */
  List<Customer> findByFirstNameNot(String name);

  List<Customer> findByFirstNameNot(String... name); // IllegalStateException

  List<Customer> findByAgeNot(int age);

  List<Customer> findByFirstNameNotAndFirstNameNot(String name, String name2);

  /*
   * NOT_IN: NotIn, IsNotIn
   * requires a collection arg
   */
  List<Customer> findByLastNameNotIn(String... name);

  /*
   * REGEX: Regex, MatchesRegex, Matches
   */
//  List<Customer> findByLastNameMatches(String regex); // Unsupported: postgresql ??

  /*
   * STARTING_WITH: StartingWith, IsStartingWith, StartsWith
   */
  List<Customer> findByLastNameStartingWithIgnoreCase(String start);

  /*
   * TRUE: True, IsTrue
   */
  List<Customer> findByActiveIsTrue();

  /*
   * False: False, IsFalse
   */
  List<Customer> findByActiveIsFalse();

  /* =============================================================
   *                 QUERY PREDICATE MODIFIER KEYWORDS
   ===============================================================*/

  /*
   * IgnoreCase, IgnoringCase
   */
  List<Customer> findByLastNameNotInIgnoreCase(String... name);

  /*
   * AllIgnoreCase, AllIgnoringCase
   * Ignore case for all suitable properties. Used somewhere in the query method predicate.
   */


  /*
   * OrderBy…
   */

  List<Customer> findAllByOrderByAgeAsc();

  List<Customer> findAllByOrderByAgeDesc();

}

