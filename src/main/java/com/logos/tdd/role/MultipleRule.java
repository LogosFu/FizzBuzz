package com.logos.tdd.role;

import static com.logos.tdd.NumberUtil.isMultipleOf;

import com.logos.tdd.type.ShoutType;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MultipleRule implements SoundOffRule {

  @Override
  public String soundOff(Integer index) {
   return   Arrays.stream(ShoutType.values())
        .filter(ShoutType -> isMultipleOf(index, ShoutType.getDividend()))
        .map(ShoutType::toString).collect(Collectors.joining());
  }
}
