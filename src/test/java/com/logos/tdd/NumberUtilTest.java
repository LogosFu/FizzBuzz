package com.logos.tdd;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumberUtilTest {

  @ParameterizedTest
  @CsvSource({"1,1,true", "4,2,true", "9,2,false", "63,7,true"})
  void isMultipleOf(Integer index, Integer dividend, Boolean result) {
    NumberUtil numberUtil = new NumberUtil();
    assertThat(numberUtil.isMultipleOf(index, dividend)).isEqualTo(result);
  }

  @ParameterizedTest
  @CsvSource({"12,2,true", "133,2,false", "199,1,true", "1024,9,false", "1999,99,true",
      "1998,18,false"})
  void hasCharts(Integer index, String chart, Boolean result) {
    NumberUtil numberUtil = new NumberUtil();
    assertThat(numberUtil.hasCharts(index, chart)).isEqualTo(result);
  }
}