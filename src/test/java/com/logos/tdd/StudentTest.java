package com.logos.tdd;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class StudentTest {

  @Test
  void should_return_number_when_sound_off_given_student_number_not_have_special_chart_and_not_multiple_of_3_5_7() {
    Integer index = 1;
    NumberUtil numberUtil = Mockito.mock(NumberUtil.class);

    when(numberUtil.isMultipleOf(index, 3)).thenReturn(false);
    when(numberUtil.isMultipleOf(index, 5)).thenReturn(false);
    when(numberUtil.isMultipleOf(index, 7)).thenReturn(false);
    when(numberUtil.hasCharts(index, "3")).thenReturn(false);
    when(numberUtil.hasCharts(index, "5")).thenReturn(false);
    when(numberUtil.hasCharts(index, "7")).thenReturn(false);
    final Student student = Student.builder().index(index).build();
    assertThat(student.soundOff()).isEqualTo(index.toString());
  }
}