package com.hloms.spring.data.usage;

import com.hloms.spring.data.domain.Customer;
import com.hloms.spring.data.repository.PredicateKeyAndMod;
import com.hloms.spring.data.common.UtilsGeneral;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PredicateKeywordsAndModifiers {

  private final PredicateKeyAndMod predicateKeyAndMod;

  public PredicateKeywordsAndModifiers(final PredicateKeyAndMod predicateKeyAndMod) {
    this.predicateKeyAndMod = predicateKeyAndMod;
  }

  public static void log(final String msg, final List<Customer> predicateKeyAndMod) {
    UtilsGeneral.logInfo(msg);
    predicateKeyAndMod.forEach(customer -> {
      UtilsGeneral.log.info(customer + "");
    });
    UtilsGeneral.log.info("");
  }

  public void usingPredicateKeywordsAndModifiers() {
    log("findByFirstNameAndLastName('Jack','Bauer')",
        predicateKeyAndMod.findByFirstNameAndLastName("Jack", "Bauer"));

    log("findByFirstNameOrLastName('Jack','Bauer')",
        predicateKeyAndMod.findByFirstNameOrLastName("Jack", "Bauer"));

    log("findByLastNameContains('a')",
        predicateKeyAndMod.findByLastNameContains("a"));

    log("findByAgeBetween(10, 40)",
        predicateKeyAndMod.findByAgeBetween(10, 40));

    log("findByAgeAndFirstNameBetween(31, 'a', 'f')",
        predicateKeyAndMod.findByAgeAndFirstNameBetween(31, "a", "f"));

    log("findByLastNameEndingWith('r')",
        predicateKeyAndMod.findByLastNameEndingWith("r"));

    log("findByAgeGreaterThan(27)",
        predicateKeyAndMod.findByAgeGreaterThan(27));

    log("findByAgeGreaterThanEqual(27)",
        predicateKeyAndMod.findByAgeGreaterThanEqual(27));

//    likePredicate();

    log("findByFirstNameNotAndFirstNameNot('jack', 'Mpho')",
        predicateKeyAndMod.findByFirstNameNotAndFirstNameNot("jack", "Mpho"));

    log("findByAgeNot(20)",
        predicateKeyAndMod.findByAgeNot(20));

    log("findByLastNameNotIn('bauer', 'Dessler')",
        predicateKeyAndMod.findByLastNameNotInIgnoreCase("bauer", "Dessler"));

//    notLikePredicate();

    log("findByLastNameStartingWithIgnoreCase('b')",
        predicateKeyAndMod.findByLastNameStartingWithIgnoreCase("b"));

    log("findByActiveTrue()",
        predicateKeyAndMod.findByActiveIsTrue());

    log("findByActiveIsFalse()",
        predicateKeyAndMod.findByActiveIsFalse());

    log("findByLastNameNotInAllIgnoreCase(\"bauer\")",
        predicateKeyAndMod.findByLastNameNotInIgnoreCase("bauer"));

    log("findAllByOrderByAgeAsc()",
        predicateKeyAndMod.findAllByOrderByAgeAsc());


  }

  public void likePredicate() {

    log("findByFirstNameLike('Ja%')", // names that START with 'Ja'
        predicateKeyAndMod.findByFirstNameLike("Ja%"));

    log("findByFirstNameLike('%e')", // names that END with 'e'
        predicateKeyAndMod.findByFirstNameLike("%e"));

    log("findByFirstNameLike('%c%')", // names that have 'c' in any position
        predicateKeyAndMod.findByFirstNameLikeAllIgnoreCase("%c%"));

    log("findByFirstNameLike('j%c')", // names that start with 'a' and end in 'k'
        predicateKeyAndMod.findByFirstNameLikeAllIgnoreCase("j%k"));

    log("findByFirstNameLike('_i%')", // names that have 'i' in the second position
        predicateKeyAndMod.findByFirstNameLikeAllIgnoreCase("_i%"));

    log("findByFirstNameLike('e_%')", // names that start with 'e' and are 2chars in length
        predicateKeyAndMod.findByFirstNameLikeAllIgnoreCase("e_%"));

    log("findByFirstNameLike('e__%')", // names that start with 'e' and are 3chars in length
        predicateKeyAndMod.findByFirstNameLikeAllIgnoreCase("e__%"));

  }

  public void notLikePredicate() {
    // CASE SENSITIVE

    log("findByFirstNameNotLike('Ja%')", // names that NOT START with 'Ja'
        predicateKeyAndMod.findByFirstNameNotLike("Ja%"));

    log("findByFirstNameNotLike('d%')", // names that NOT END with 'd'
        predicateKeyAndMod.findByFirstNameNotLike("d%"));

    log("findByFirstNameNotLike('%d')", // names that END with 'd'
        predicateKeyAndMod.findByFirstNameNotLike("%d"));
  }

}
