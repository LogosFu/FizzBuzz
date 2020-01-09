package com.logos.tdd;

import java.util.stream.IntStream;
import org.apache.commons.lang3.StringUtils;

public class Instructor {

  public static void main(String[] args) {
    IntStream.range(1, 1024).forEach(number -> System.out.println(soundOff(number)));
  }

  protected static String soundOff(Integer number) {

    if (IsNumberHasSpecialCharacters(number, "7")) {
      return ruleForNumberHas7(number);
    }
    if (IsNumberHasSpecialCharacters(number, "5")) {
      return ruleForNumberHas5(number);
    }
    if (IsNumberHasSpecialCharacters(number, "3")) {
      return DividendENUM.Fizz.name();
    }
    return NormalMultipleRule(number);
  }

  private static String ruleForNumberHas7(Integer number) {
    String soundOff = "";
    soundOff += ruleForMultiple(number, DividendENUM.Fizz);
    soundOff += ruleForMultiple(number, DividendENUM.Whizz);
    return soundOff;
  }

  private static String ruleForMultiple(Integer number, DividendENUM dividend) {
    String ruleResult = "";
    if (isNumberMultipleOfDividend(number, dividend.getDividend())) {
      ruleResult = dividend.name();
    }
    return ruleResult;
  }

  private static String ruleForNumberHas5(Integer number) {
    String soundOff = "";
    soundOff += ruleForMultiple(number, DividendENUM.Buzz);
    soundOff += ruleForMultiple(number, DividendENUM.Whizz);
    return soundOff;
  }

  private static boolean IsNumberHasSpecialCharacters(Integer number, String specialCharacters) {
    return number.toString().contains(specialCharacters);
  }

  private static String NormalMultipleRule(Integer number) {
    String soundOff = "";
    soundOff += ruleForMultiple(number, DividendENUM.Fizz);
    soundOff += ruleForMultiple(number, DividendENUM.Buzz);
    soundOff += ruleForMultiple(number, DividendENUM.Whizz);
    return StringUtils.isBlank(soundOff) ? number.toString() : soundOff;
  }

  private static boolean isNumberMultipleOfDividend(Integer number, Integer dividend) {
    return number % dividend == 0;
  }
}
