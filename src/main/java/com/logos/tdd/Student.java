package com.logos.tdd;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {

  private Integer index;

  public String soundOff() {
    return index.toString();
  }


}
