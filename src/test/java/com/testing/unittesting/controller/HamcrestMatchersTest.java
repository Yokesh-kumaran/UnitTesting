package com.testing.unittesting.controller;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

//import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersTest {
    @Test
    public void learning() {
        List<Integer> numbers = Arrays.asList(10, 20, 30);

//        assertThat(numbers, anyOf(hasSize(3), hasSize(10)));
//        assertThat(numbers, hasItem(10));
//        assertThat(numbers, everyItem(greaterThanOrEqualTo(10)));
//        assertThat(numbers, everyItem(lessThanOrEqualTo(30)));
//
//        assertThat("", isEmptyString());
//        assertThat("abcd", anyOf(containsString("b"), containsString("e")));

        assertThat(numbers)
                .hasSize(3)
                .contains(10, 20)
                .allMatch(x -> x > 9.5)
                .allMatch(x -> x <= 30)
                .noneMatch(x -> x < 0 && x > 100);

        assertThat("")
                .isEmpty();

        assertThat("abcde")
                .contains("bcd")
                .startsWith("a")
                .endsWith("de");
    }
}
