package com.logos.tdd;

import java.util.stream.IntStream;
import org.apache.commons.lang3.StringUtils;

public class SoundOff {

  public static void main(String[] args) {
    IntStream.range(1, 1024).forEach(number -> System.out.println(soundOff(number)));
  }

  protected static String soundOff(Integer number) {

    if (IsNumberHasSpecialCharacters(number,"7")){
      return ruleForNumberHas7(number);
    }
    if (IsNumberHasSpecialCharacters(number,"5")){
      return ruleForNumberHas5(number);
    }
    if (IsNumberHasSpecialCharacters(number, "3")) {
      return "Fizz";
    }
    String x = NormalMutipleRule(number);
    if (x != null) {
      return x;
    }
    return number.toString();
  }

  private static String ruleForNumberHas7(Integer number) {
    String soundOff = "";
    if (isNumberMultipleOfDividend(number, 3)) {
      soundOff += "Fizz";
    }
    if (isNumberMultipleOfDividend(number, 7)) {
      soundOff += "Whizz";
    }
    return soundOff;
  }

  private static String ruleForNumberHas5(Integer number) {
    String soundOff = "";

    if (isNumberMultipleOfDividend(number, 5)) {
      soundOff += "Buzz";
    }
    if (isNumberMultipleOfDividend(number, 7)) {
      soundOff += "Whizz";
    }
    return soundOff;
  }

  private static boolean IsNumberHasSpecialCharacters(Integer number, String specialCharacters) {
    return number.toString().contains(specialCharacters);
  }

  private static String NormalMutipleRule(Integer number) {
    String soundOff = "";
    if (isNumberMultipleOfDividend(number, 3)) {
      soundOff += "Fizz";
    }
    if (isNumberMultipleOfDividend(number, 5)) {
      soundOff += "Buzz";
    }
    if (isNumberMultipleOfDividend(number, 7)) {
      soundOff += "Whizz";
    }

    return StringUtils.isBlank(soundOff) ? null : soundOff;
  }

  private static boolean isNumberMultipleOfDividend(Integer number, Integer dividend) {
    return number % dividend == 0;
  }
}
