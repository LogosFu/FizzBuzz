package com.logos.tdd.role;

import static com.logos.tdd.NumberUtil.isMultipleOf;
import static com.logos.tdd.type.ShoutType.Buzz;
import static com.logos.tdd.type.ShoutType.Whizz;

import com.logos.tdd.NumberUtil;
import com.logos.tdd.type.ShoutType;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Chart5Rule implements SoundOffRule {

  @Override
  public String soundOff(Integer index) {

    if (NumberUtil.isMultipleOfAny(index, Buzz.getDividend(), Whizz.getDividend())) {
      return Arrays.stream(new ShoutType[]{Buzz, Whizz})
          .filter(ShoutType -> isMultipleOf(index, ShoutType.getDividend()))
          .map(ShoutType::toString).collect(Collectors.joining());
    } else {
      return index.toString();
    }
  }
}
