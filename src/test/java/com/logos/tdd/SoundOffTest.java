package com.logos.tdd;

import static com.logos.tdd.SoundOff.soundOff;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SoundOffTest {

  @ParameterizedTest
  @CsvSource({"1,1","2,2","19,19","22,22"})
  void shouldReturnNumberStringWhenSoundOffGivenNormalNumber(Integer number,String soundOff) {
    assertThat(soundOff(number)).isEqualTo(soundOff);
  }
  @ParameterizedTest
  @CsvSource({"3,Fizz","6,Fizz","9,Fizz","27,Fizz"})
  void shouldReturnFizzWhenSoundOffGivenNumberMultipleOf3(Integer number,String soundOff){
    assertThat(soundOff(number)).isEqualTo(soundOff);
  }
}