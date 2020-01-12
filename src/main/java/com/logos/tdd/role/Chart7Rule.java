package com.logos.tdd.role;

import static com.logos.tdd.NumberUtil.hasCharts;
import static com.logos.tdd.NumberUtil.isMultipleOf;
import static com.logos.tdd.NumberUtil.isMultipleOfAny;
import static com.logos.tdd.type.ShoutType.Fizz;
import static com.logos.tdd.type.ShoutType.Whizz;

import com.logos.tdd.type.ShoutType;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Chart7Rule implements SoundOffRule {

  @Override
  public String soundOff(Integer index) {
    if (hasCharts(index, Fizz.getDividend().toString())) {
      return Fizz.toString();
    }
    if (isMultipleOfAny(index, Fizz.getDividend(), Whizz.getDividend())) {
      return Arrays.stream(new ShoutType[]{Fizz, Whizz})
          .filter(ShoutType -> isMultipleOf(index, ShoutType.getDividend()))
          .map(ShoutType::toString).collect(Collectors.joining());
    }
    return index.toString();
  }
}
