package com.logos.tdd;

import static com.logos.tdd.type.ShoutType.Buzz;
import static com.logos.tdd.type.ShoutType.Fizz;
import static com.logos.tdd.type.ShoutType.Whizz;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class) // 告诉JUnit使用PowerMockRunner进行测试
@PrepareForTest({NumberUtil.class}) // 所有需要测试的类列在此处，适用于模拟final类或有final, private, static, native方法的类
@PowerMockIgnore("javax.management.*") //为了解决使用powermock后，提示classloader错误
public class StudentTest {


  @Test
  public void should_return_number_when_sound_off_given_student_number_not_have_special_chart_and_not_multiple_of_3_5_7() {
    Integer index = 1;
    PowerMockito.mockStatic(NumberUtil.class);
    when(NumberUtil.isMultipleOf(index, 3)).thenReturn(false);
    when(NumberUtil.isMultipleOf(index, 5)).thenReturn(false);
    when(NumberUtil.isMultipleOf(index, 7)).thenReturn(false);
    when(NumberUtil.hasCharts(index, "3")).thenReturn(false);
    when(NumberUtil.hasCharts(index, "5")).thenReturn(false);
    when(NumberUtil.hasCharts(index, "7")).thenReturn(false);
    final Student student = new Student(index);
    assertThat(student.soundOff()).isEqualTo(index.toString());
  }

  @Test
  public void should_return_fizz_buzz_whizz_when_sound_off_given_student_index_is_multi_ple_of_3_5_7() {
    Integer index = 1;
    PowerMockito.mockStatic(NumberUtil.class);
    when(NumberUtil
        .isMultipleOfAny(index, Fizz.getDividend(), Buzz.getDividend(), Whizz.getDividend()))
        .thenReturn(true);
    when(NumberUtil.hasCharts(index, Fizz.getDividend().toString())).thenReturn(false);
    when(NumberUtil.isMultipleOf(index, Fizz.getDividend())).thenReturn(true);
    final Student student = new Student(index);
    assertThat(student.soundOff()).isEqualTo(Fizz.toString());
  }

  @Test
  public void should_return_both_enum_when_sound_off_given_student_index_is_both_multi_ple_of3() {
    Integer index = 1;
    PowerMockito.mockStatic(NumberUtil.class);
    when(NumberUtil
        .isMultipleOfAny(index, Fizz.getDividend(), Buzz.getDividend(), Whizz.getDividend()))
        .thenReturn(true);
    when(NumberUtil.hasCharts(index, Fizz.getDividend().toString())).thenReturn(false);
    when(NumberUtil.isMultipleOf(index, Fizz.getDividend())).thenReturn(true);
    when(NumberUtil.isMultipleOf(index, Buzz.getDividend())).thenReturn(true);
    when(NumberUtil.isMultipleOf(index, Whizz.getDividend())).thenReturn(false);

    assertThat(new Student(index).soundOff()).isEqualTo(Fizz.toString() + Buzz.toString());
  }

  @Test
  public void should_return_both_enum_when_sound_off_given_student_index_is_both_multi_ple_of7() {

    Integer index = 3;
    PowerMockito.mockStatic(NumberUtil.class);

    when(NumberUtil
        .isMultipleOfAny(index, Fizz.getDividend(), Buzz.getDividend(), Whizz.getDividend()))
        .thenReturn(true);
    when(NumberUtil.hasCharts(index, Fizz.getDividend().toString())).thenReturn(false);
    when(NumberUtil.isMultipleOf(index, Fizz.getDividend())).thenReturn(false);
    when(NumberUtil.isMultipleOf(index, Buzz.getDividend())).thenReturn(true);
    when(NumberUtil.isMultipleOf(index, Whizz.getDividend())).thenReturn(true);

    assertThat(new Student(index).soundOff()).isEqualTo(Buzz.toString() + Whizz.toString());
  }

  @Test
  public void should_return_both_enum_when_sound_off_given_student_index_is_both_multi_ple_of5() {
    Integer index = 2;

    PowerMockito.mockStatic(NumberUtil.class);

    when(NumberUtil
        .isMultipleOfAny(index, Fizz.getDividend(), Buzz.getDividend(), Whizz.getDividend()))
        .thenReturn(true);
    when(NumberUtil.hasCharts(index, Fizz.getDividend().toString())).thenReturn(false);

    when(NumberUtil.isMultipleOf(index, Fizz.getDividend())).thenReturn(true);
    when(NumberUtil.isMultipleOf(index, Buzz.getDividend())).thenReturn(false);
    when(NumberUtil.isMultipleOf(index, Whizz.getDividend())).thenReturn(true);

    assertThat(new Student(index).soundOff()).isEqualTo(Fizz.toString() + Whizz.toString());
  }

  @Test
  public void should_return_fizz_when_sound_off_given_student_index_has3() {

    Integer index = 1;

    PowerMockito.mockStatic(NumberUtil.class);
    when(NumberUtil.hasCharts(index, Fizz.getDividend().toString())).thenReturn(true);
    when(NumberUtil
        .isMultipleOfAny(index, Fizz.getDividend(), Buzz.getDividend(), Whizz.getDividend()))
        .thenReturn(true);
    assertThat(new Student(index).soundOff()).isEqualTo(Fizz.toString());
  }

  @Test
  public void shouldReturnFizzBuzzWhenSoundOffGivenStudentHas5AndIsMultipleOf3And5And7() {
    Integer index = 1;

    PowerMockito.mockStatic(NumberUtil.class);
    when(NumberUtil.hasCharts(index, Buzz.getDividend().toString())).thenReturn(true);
    when(NumberUtil
        .isMultipleOfAny(index, Buzz.getDividend(), Whizz.getDividend()))
        .thenReturn(true);
    when(NumberUtil.isMultipleOf(index,Buzz.getDividend())).thenReturn(true);
    when(NumberUtil.isMultipleOf(index,Whizz.getDividend())).thenReturn(true);
    when(NumberUtil.isMultipleOf(index,Fizz.getDividend())).thenReturn(true);

    assertThat(new Student(index).soundOff()).isEqualTo(Buzz.toString()+Whizz.toString());
  }
  @Test
  public void shouldReturnNumberWhenSoundOffGivenStudentHas5AndIsNotMultipleOfAny() {
    Integer index = 1;

    PowerMockito.mockStatic(NumberUtil.class);
    when(NumberUtil.hasCharts(index, Buzz.getDividend().toString())).thenReturn(true);
    when(NumberUtil
        .isMultipleOfAny(index, Buzz.getDividend(), Whizz.getDividend()))
        .thenReturn(false);
    when(NumberUtil.isMultipleOf(index,Buzz.getDividend())).thenReturn(false);
    when(NumberUtil.isMultipleOf(index,Whizz.getDividend())).thenReturn(false);
    when(NumberUtil.isMultipleOf(index,Fizz.getDividend())).thenReturn(false);

    assertThat(new Student(index).soundOff()).isEqualTo(index.toString());
  }
  @Test
  public void shouldReturnNumberWhenSoundOffGivenStudentHas5AndIsNotMultipleOf3() {
    Integer index = 1;

    PowerMockito.mockStatic(NumberUtil.class);
    when(NumberUtil.hasCharts(index, Buzz.getDividend().toString())).thenReturn(true);
    when(NumberUtil
        .isMultipleOfAny(index, Buzz.getDividend(), Whizz.getDividend()))
        .thenReturn(false);
    when(NumberUtil.isMultipleOf(index,Buzz.getDividend())).thenReturn(false);
    when(NumberUtil.isMultipleOf(index,Whizz.getDividend())).thenReturn(false);
    when(NumberUtil.isMultipleOf(index,Fizz.getDividend())).thenReturn(true);

    assertThat(new Student(index).soundOff()).isEqualTo(index.toString());
  }

  @Test
  public void shouldReturnNumberWhenSoundOffGivenStudentHas5AndIsNotMultipleOf7() {
    Integer index = 1;

    PowerMockito.mockStatic(NumberUtil.class);
    when(NumberUtil.hasCharts(index, Buzz.getDividend().toString())).thenReturn(true);
    when(NumberUtil
        .isMultipleOfAny(index, Buzz.getDividend(), Whizz.getDividend()))
        .thenReturn(true);
    when(NumberUtil.isMultipleOf(index,Buzz.getDividend())).thenReturn(false);
    when(NumberUtil.isMultipleOf(index,Whizz.getDividend())).thenReturn(true);
    when(NumberUtil.isMultipleOf(index,Fizz.getDividend())).thenReturn(true);

    assertThat(new Student(index).soundOff()).isEqualTo(Whizz.toString());
  }
}