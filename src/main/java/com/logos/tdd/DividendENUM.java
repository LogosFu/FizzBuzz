package com.logos.tdd;

import lombok.Getter;

public enum DividendENUM {
  Fizz(3),
  Buzz(5),
  Whizz(7);
  @Getter
  private Integer dividend;

  DividendENUM(Integer dividend) {
    this.dividend = dividend;
  }
}
