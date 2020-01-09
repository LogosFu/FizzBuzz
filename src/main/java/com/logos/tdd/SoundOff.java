package com.logos.tdd;

import java.util.stream.IntStream;

public class SoundOff {

  public static void main(String[] args) {
    IntStream.range(1, 1024).forEach(number -> System.out.println(soundOff(number)));
  }

  protected static String soundOff(Integer number) {
    if (number % 3 == 0) {
      return "Fizz";
    }
    return number.toString();
  }
}
