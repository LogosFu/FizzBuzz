package com.logos.tdd;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {

  private Integer index;
  private SoundOffRule rule;

  public Student(Integer index, SoundOffRule rule) {
    this.index = index;
    this.rule = new NormalRule();
  }

  public String soundOff() {
    return rule.soundOff(index);
  }
}
