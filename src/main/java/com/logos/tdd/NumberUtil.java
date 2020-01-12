package com.logos.tdd;

public class NumberUtil {

  public Boolean isMultipleOf(Integer index, Integer dividend) {
    return index % dividend == 0;
  }

  public Boolean hasCharts(Integer index, String chart) {
    return index.toString().contains(chart);
  }
}
