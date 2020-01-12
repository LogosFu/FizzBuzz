package com.logos.tdd.role;

import static com.logos.tdd.NumberUtil.isMultipleOf;

import com.logos.tdd.type.FizzBuzzWhizz;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MultipleRule implements SoundOffRule {

  @Override
  public String soundOff(Integer index) {
   return   Arrays.stream(FizzBuzzWhizz.values())
        .filter(fizzBuzzWhizz -> isMultipleOf(index, fizzBuzzWhizz.getDividend()))
        .map(FizzBuzzWhizz::toString).collect(Collectors.joining());
  }
}
