package com.logos.tdd;

import java.util.Arrays;

public class NumberUtil {

  public static Boolean isMultipleOf(Integer index, Integer dividend) {
    return index % dividend == 0;
  }

  public static Boolean isMultipleOfAny(Integer index, Integer... dividends) {
    return Arrays.stream(dividends).anyMatch(dividend -> isMultipleOf(index, dividend));
  }

  public static Boolean hasCharts(Integer index, String chart) {
    return index.toString().contains(chart);
  }
}
