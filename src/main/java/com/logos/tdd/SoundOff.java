package com.logos.tdd;

import java.util.stream.IntStream;

public class SoundOff {

  public static void main(String[] args) {
    IntStream.range(1, 1024).mapToObj(Student::new).map(Student::soundOff).forEach(
        System.out::println);
  }
}
