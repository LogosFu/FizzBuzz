package com.logos.tdd;

import static com.logos.tdd.type.FizzBuzzWhizz.Buzz;
import static com.logos.tdd.type.FizzBuzzWhizz.Fizz;
import static com.logos.tdd.type.FizzBuzzWhizz.Whizz;
import static org.assertj.core.api.Assertions.assertThat;
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
    when(NumberUtil.isMultipleOf(index, Fizz.getDividend())).thenReturn(true);
    final Student student = new Student(index);
    assertThat(student.soundOff()).isEqualTo(Fizz.toString());
  }

  @Test
  public void should_return_both_enum_when_sound_off_given_student_index_is_both_multi_ple_of3() {
    Integer index1 = 1;
    PowerMockito.mockStatic(NumberUtil.class);
    when(NumberUtil
        .isMultipleOfAny(index1, Fizz.getDividend(), Buzz.getDividend(), Whizz.getDividend()))
        .thenReturn(true);

    when(NumberUtil.isMultipleOf(index1, Fizz.getDividend())).thenReturn(true);
    when(NumberUtil.isMultipleOf(index1, Buzz.getDividend())).thenReturn(true);
    when(NumberUtil.isMultipleOf(index1, Whizz.getDividend())).thenReturn(false);

    assertThat(new Student(index1).soundOff()).isEqualTo(Fizz.toString() + Buzz.toString());
  }

  @Test
  public void should_return_both_enum_when_sound_off_given_student_index_is_both_multi_ple_of7() {

    Integer index3 = 3;
    PowerMockito.mockStatic(NumberUtil.class);

    when(NumberUtil
        .isMultipleOfAny(index3, Fizz.getDividend(), Buzz.getDividend(), Whizz.getDividend()))
        .thenReturn(true);

    when(NumberUtil.isMultipleOf(index3, Fizz.getDividend())).thenReturn(false);
    when(NumberUtil.isMultipleOf(index3, Buzz.getDividend())).thenReturn(true);
    when(NumberUtil.isMultipleOf(index3, Whizz.getDividend())).thenReturn(true);

    assertThat(new Student(index3).soundOff()).isEqualTo(Buzz.toString() + Whizz.toString());
  }

  @Test
  public void should_return_both_enum_when_sound_off_given_student_index_is_both_multi_ple_of5() {
    Integer index2 = 2;

    PowerMockito.mockStatic(NumberUtil.class);

    when(NumberUtil
        .isMultipleOfAny(index2, Fizz.getDividend(), Buzz.getDividend(), Whizz.getDividend()))
        .thenReturn(true);

    when(NumberUtil.isMultipleOf(index2, Fizz.getDividend())).thenReturn(true);
    when(NumberUtil.isMultipleOf(index2, Buzz.getDividend())).thenReturn(false);
    when(NumberUtil.isMultipleOf(index2, Whizz.getDividend())).thenReturn(true);

    assertThat(new Student(index2).soundOff()).isEqualTo(Fizz.toString() + Whizz.toString());
  }

}