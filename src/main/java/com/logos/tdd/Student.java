package com.logos.tdd;

import static com.logos.tdd.NumberUtil.hasCharts;
import static com.logos.tdd.NumberUtil.isMultipleOfAny;
import static com.logos.tdd.type.RuleType.Chart3;
import static com.logos.tdd.type.RuleType.Chart5;
import static com.logos.tdd.type.RuleType.Chart7;
import static com.logos.tdd.type.RuleType.Multiple;
import static com.logos.tdd.type.RuleType.Normal;
import static com.logos.tdd.type.RuleType.getRuleByType;

import com.logos.tdd.role.SoundOffRule;
import com.logos.tdd.type.RuleType;
import lombok.Data;

@Data
public class Student {

  private Integer index;
  private SoundOffRule rule;

  public Student(Integer index) {
    this.index = index;
    this.rule = getRuleByType(getRuleType());
  }

  public String soundOff() {
    return rule.soundOff(index);
  }

  private RuleType getRuleType() {
    if (hasCharts(index, "7")) {
      return Chart7;
    } else if (hasCharts(index, "5")) {
      return Chart5;
    } else if (hasCharts(index, "3")) {
      return Chart3;
    } else if (isMultipleOfAny(index, 3, 5, 7)) {
      return Multiple;
    } else {
      return Normal;
    }
  }
}
