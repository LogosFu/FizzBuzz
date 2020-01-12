package com.logos.tdd.type;

import com.logos.tdd.role.Chart3Rule;
import com.logos.tdd.role.Chart5Rule;
import com.logos.tdd.role.Chart7Rule;
import com.logos.tdd.role.MultipleRule;
import com.logos.tdd.role.NormalRule;
import com.logos.tdd.role.SoundOffRule;

public enum RuleType {
  Normal,
  Multiple,
  Chart3,
  Chart5,
  Chart7;

  public static SoundOffRule getRuleByType(RuleType ruleType) {
    switch (ruleType) {
      case Chart3:
        return new Chart3Rule();
      case Multiple:
        return new MultipleRule();
      case Chart5:
        return new Chart5Rule();
      case Chart7:
        return new Chart7Rule();
      default:
        return new NormalRule();
    }
  }
}
