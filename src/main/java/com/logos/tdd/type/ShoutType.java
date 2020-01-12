package com.logos.tdd.type;

import lombok.Getter;

public enum ShoutType {
  Fizz(3),
  Buzz(5),
  Whizz(7);
  @Getter
  private Integer dividend;

  ShoutType(Integer dividend) {
    this.dividend = dividend;
  }
}
