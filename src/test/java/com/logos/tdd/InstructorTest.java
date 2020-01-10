package com.logos.tdd;

import static com.logos.tdd.Instructor.soundOff;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InstructorTest {

  @ParameterizedTest
  @CsvSource({"1,1", "2,2", "19,19", "22,22","37,37"})
  void should_return_number_string_when_sound_off_given_normal_number(Integer number,
      String soundOff) {
    assertThat(soundOff(number)).isEqualTo(soundOff);
  }

  @ParameterizedTest
  @CsvSource({"3,Fizz", "6,Fizz", "9,Fizz", "27,Fizz"})
  void should_return_fizz_when_sound_off_given_number_multiple_of3(Integer number,
      String soundOff) {
    assertThat(soundOff(number)).isEqualTo(soundOff);
  }

  @ParameterizedTest
  @CsvSource({"5,Buzz", "10,Buzz", "25,Buzz", "20,Buzz"})
  void should_return_buzz_when_sound_off_given_number_multiple_of5(Integer number,
      String soundOff) {
    assertThat(soundOff(number)).isEqualTo(soundOff);
  }

  @ParameterizedTest
  @CsvSource({"7,Whizz", "14,Whizz", "28,Whizz"})
  void should_return_whizz_when_sound_off_given_number_multiple_of7(Integer number,
      String soundOff) {
    assertThat(soundOff(number)).isEqualTo(soundOff);
  }

  @ParameterizedTest
  @CsvSource({"120,FizzBuzz", "21,FizzWhizz", "210,FizzBuzzWhizz"})
  void should_return_superposition_when_sound_off_given_number_both_multiple_of3_or5_or7(
      Integer number, String soundOff) {
    assertThat(soundOff(number)).isEqualTo(soundOff);
  }

  @ParameterizedTest
  @CsvSource({"13,Fizz", "23,Fizz", "131,Fizz", "63,Fizz"})
  void shouldReturnFizzWhenSoundOffGivenNumberHas3(Integer number, String soundOff) {
    assertThat(soundOff(number)).isEqualTo(soundOff);
  }

  @ParameterizedTest
  @CsvSource({"35,BuzzWhizz", "145,Buzz"})
  void shouldReturnMultiPleRuleOf5And7WhenSoundOFGivenNumberHave5(Integer number, String soundOff) {
    assertThat(soundOff(number)).isEqualTo(soundOff);
  }

  @ParameterizedTest
  @CsvSource({"75,Fizz", "147,FizzWhizz"})
  void shouldReturnMultiPleRuleOf3And7WhenSoundOFGivenNumberHave7(Integer number, String soundOff) {
    assertThat(soundOff(number)).isEqualTo(soundOff);
  }
}