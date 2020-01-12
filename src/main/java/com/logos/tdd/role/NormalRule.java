package com.logos.tdd.role;

public class NormalRule implements SoundOffRule {

  @Override
  public String soundOff(Integer index) {
    return index.toString();
  }
}
