package com.logos.tdd;

import java.util.stream.IntStream;

public class SoundOff {

  public static void main(String[] args) {
    IntStream.range(1, 1024).forEach(number -> System.out.println(soundOff(number)));
  }

  protected static String soundOff(Integer number) {
    if (isNumberMultipleOfDividend(number, 3)) {
      return "Fizz";
    }
    if (isNumberMultipleOfDividend(number,5)){
      return "Buzz";
    }
    return number.toString();
  }

  private static boolean isNumberMultipleOfDividend(Integer number, Integer dividend) {
    return number % dividend == 0;
  }
}
