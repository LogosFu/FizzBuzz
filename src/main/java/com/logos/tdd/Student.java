package com.logos.tdd;

import static com.logos.tdd.NumberUtil.hasCharts;
import static com.logos.tdd.type.FizzBuzzWhizz.Buzz;
import static com.logos.tdd.type.FizzBuzzWhizz.Fizz;
import static com.logos.tdd.type.FizzBuzzWhizz.Whizz;
import static com.logos.tdd.NumberUtil.isMultipleOfAny;

import com.logos.tdd.role.Chart3Rule;
import com.logos.tdd.role.MultipleRule;
import com.logos.tdd.role.NormalRule;
import com.logos.tdd.role.SoundOffRule;
import lombok.Data;

@Data
public class Student {

  private Integer index;
  private SoundOffRule rule;

  public Student(Integer index) {
    this.index = index;
    if (isMultipleOfAny(index, Fizz.getDividend(), Buzz.getDividend(), Whizz.getDividend())) {
      this.rule = new MultipleRule();
    } else if (hasCharts(index, Fizz.getDividend().toString())) {
      this.rule = new Chart3Rule();
    } else {
      this.rule = new NormalRule();
    }
  }

  public String soundOff() {
    return rule.soundOff(index);
  }
}
