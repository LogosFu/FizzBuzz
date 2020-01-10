package com.logos.tdd;

import static com.logos.tdd.DividendENUM.Buzz;
import static com.logos.tdd.DividendENUM.Fizz;
import static com.logos.tdd.DividendENUM.Whizz;
import static java.util.stream.Collectors.joining;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Instructor {

  public static void main(String[] args) {
    IntStream.range(1, 1024).forEach(number -> System.out.println(soundOff(number)));
  }

  protected static String soundOff(Integer number) {

    if (isNumberHasSpecialCharacters(number, "7")) {
      return ruleStrategy(number, Fizz, Whizz);
    }
    if (isNumberHasSpecialCharacters(number, "5")) {
      return ruleStrategy(number, Buzz, Whizz);
    }


    if (isNumberHasSpecialCharacters(number, "3")) {
      return Fizz.name();
    }
    if (isNumberMultipleOfAnyDividend(number, 3, 5, 7)) {
      return ruleStrategy(number, Fizz, Buzz, Whizz);
    }
    return number.toString();
  }

  private static String ruleStrategy(Integer number, DividendENUM... dividends) {
    return Arrays.stream(dividends).map(dividend -> ruleForMultiple(number, dividend))
        .collect(joining());
  }

  private static String ruleForMultiple(Integer number, DividendENUM dividend) {
    return isNumberMultipleOfDividend(number, dividend.getDividend()) ? dividend.name() : "";
  }

  private static boolean isNumberHasSpecialCharacters(Integer number, String specialCharacters) {
    return number.toString().contains(specialCharacters);
  }

  private static boolean isNumberMultipleOfAnyDividend(Integer number, Integer... dividends) {
    return Arrays.stream(dividends).anyMatch(dividend -> number % dividend == 0);
  }

  private static boolean isNumberMultipleOfDividend(Integer number, Integer dividend) {
    return number % dividend == 0;
  }
}
