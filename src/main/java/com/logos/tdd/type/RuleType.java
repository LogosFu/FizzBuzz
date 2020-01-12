package com.logos.tdd.type;

import com.logos.tdd.role.Chart3Rule;
import com.logos.tdd.role.MultipleRule;
import com.logos.tdd.role.NormalRule;
import com.logos.tdd.role.SoundOffRule;

public enum RuleType {
  Normal,
  Multiple,
  Chart3;

  public static SoundOffRule getRuleByType(RuleType ruleType) {
    switch (ruleType) {
      case Chart3:
        return new Chart3Rule();
      case Multiple:
        return new MultipleRule();
      default:
        return new NormalRule();
    }
  }
}
