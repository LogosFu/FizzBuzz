package com.logos.tdd;

import static com.logos.tdd.NumberUtil.hasCharts;
import static com.logos.tdd.NumberUtil.isMultipleOfAny;
import static com.logos.tdd.type.RuleType.Chart3;
import static com.logos.tdd.type.RuleType.Multiple;
import static com.logos.tdd.type.RuleType.Normal;
import static com.logos.tdd.type.RuleType.getRuleByType;
import static com.logos.tdd.type.ShoutType.Buzz;
import static com.logos.tdd.type.ShoutType.Fizz;
import static com.logos.tdd.type.ShoutType.Whizz;

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
    if (hasCharts(index, Fizz.getDividend().toString())) {
      return Chart3;
    } else if (isMultipleOfAny(index, Fizz.getDividend(), Buzz.getDividend(),
        Whizz.getDividend())) {
      return Multiple;
    } else {
      return Normal;
    }
  }
}
