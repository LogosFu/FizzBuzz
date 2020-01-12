package com.logos.tdd.role;

import static com.logos.tdd.type.ShoutType.Fizz;

public class Chart3Rule implements SoundOffRule {

  @Override
  public String soundOff(Integer index) {
    return Fizz.toString();
  }
}
