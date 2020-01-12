package com.logos.tdd;

import lombok.Getter;

public enum FizzBuzzWhizz {
  Fizz(3),
  Buzz(5),
  Whizz(7);
  @Getter
  private Integer dividend;

  FizzBuzzWhizz(Integer dividend) {
    this.dividend = dividend;
  }
}
