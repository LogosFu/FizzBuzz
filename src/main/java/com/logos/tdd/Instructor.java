package com.logos.tdd;

import static com.logos.tdd.DividendENUM.Buzz;
import static com.logos.tdd.DividendENUM.Fizz;
import static com.logos.tdd.DividendENUM.Whizz;
import static java.util.stream.Collectors.joining;

import java.util.Arrays;
import java.util.stream.IntStream;
import org.apache.commons.lang3.StringUtils;

public class Instructor {

  public static void main(String[] args) {
    IntStream.range(1, 1024)
        .forEach(studentIndex -> System.out.println(studentIndex + "==》" + soundOff(studentIndex)));
  }

  protected static String soundOff(Integer studentIndex) {

    if (hasSpecialCharacters(studentIndex, "7")) {
      return ruleStrategy(studentIndex, Fizz, Whizz);
    }
    if (hasSpecialCharacters(studentIndex, "5")) {
      return ruleStrategy(studentIndex, Buzz, Whizz);
    }
    if (hasSpecialCharacters(studentIndex, "3")) {
      return Fizz.name();
    }
    if (multipleOfAny(studentIndex, 3, 5, 7)) {
      return ruleStrategy(studentIndex, Fizz, Buzz, Whizz);
    }
    return studentIndex.toString();
  }

  private static String ruleStrategy(Integer number, DividendENUM... dividends) {
    final String result = Arrays.stream(dividends)
        .map(dividend -> ruleForMultiple(number, dividend))
        .collect(joining());
    return StringUtils.isBlank(result) ? number.toString() : result;
  }

  private static String ruleForMultiple(Integer number, DividendENUM dividend) {
    return isNumberMultipleOfDividend(number, dividend.getDividend()) ? dividend.name() : "";
  }

  private static boolean hasSpecialCharacters(Integer number, String specialCharacters) {
    return number.toString().contains(specialCharacters);
  }

  private static boolean multipleOfAny(Integer number, Integer... dividends) {
    return Arrays.stream(dividends).anyMatch(dividend -> number % dividend == 0);
  }

  private static boolean isNumberMultipleOfDividend(Integer number, Integer dividend) {
    return number % dividend == 0;
  }
}
